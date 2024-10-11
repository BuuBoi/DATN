package com.dnanh01.backend.service.impl;

import com.dnanh01.backend.dao.iface.UserDao;
import com.dnanh01.backend.dto.request.PasswordChangeDto;
import com.dnanh01.backend.dto.request.UserRegistrationDto;
import com.dnanh01.backend.dto.request.UserUpdateOrDeleteDto;
import com.dnanh01.backend.dto.response.UserResponseDto;
import com.dnanh01.backend.exception.AppException;
import com.dnanh01.backend.exception.ErrorCode;
import com.dnanh01.backend.model.domain.Role;
import com.dnanh01.backend.model.domain.User;
import com.dnanh01.backend.service.iface.RoleService;
import com.dnanh01.backend.service.iface.UserService;
import com.dnanh01.backend.utils.UserUtils;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final RoleService roleService;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleService roleService) {
        this.userDao = userDao;
        this.roleService = roleService;
        //this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponseDto addUser(UserRegistrationDto userRegistrationDto) {
        if (userDao.findByEmail(userRegistrationDto.getEmail()).isPresent()) {
            throw new AppException(ErrorCode.Email_ALREADY_EXISTS);
        }
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);


        User user = new User();
        user.setEmail(userRegistrationDto.getEmail());
        user.setPasswordHash(passwordEncoder.encode(userRegistrationDto.getPassword()));
        System.out.println("Password: " + passwordEncoder.encode(userRegistrationDto.getPassword()));
        user.setDisplayName(userRegistrationDto.getDisplayName());
        user.setAvatarUrl(userRegistrationDto.getAvatarUrl());
        user.setPhoneNumber(userRegistrationDto.getPhoneNumber());
        //user.setPaymentInformation(userRegistrationDto.getPaymentInformation());
        user.setVerified(false); // Mặc định người dùng chưa được xác thực
        Role role = roleService.findRole("AA");

        if (role == null) {
            role = roleService.createRole("AA");
        }
        user.setRole(role); // Thiết lập vai trò mặc định


        user = userDao.save(user);
        return UserUtils.convertToDTO(user);

    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userDao.findAll(Collections.emptyMap()).stream().map(UserUtils::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getUser(String id) {
        User user = userDao.findById(UUID.fromString(id)).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        return UserUtils.convertToDTO(user);
    }

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Override
    @Transactional
    public UserResponseDto updateUser(String id, UserUpdateOrDeleteDto userUpdateOrDeleteDto) {
        logger.info("Updating user in service layer. ID: {}", id);
        return userDao.findById(UUID.fromString(id)).map(user -> {
            logger.debug("Found user: {}", user);
            user.setDisplayName(userUpdateOrDeleteDto.getDisplayName());
            user.setAvatarUrl(userUpdateOrDeleteDto.getAvatarUrl());
            user.setPhoneNumber(userUpdateOrDeleteDto.getPhoneNumber());
            user.setPaymentInformation(userUpdateOrDeleteDto.getPaymentInformation());
            User savedUser = userDao.save(user);
            logger.info("User saved to database: {}", savedUser);
            return UserUtils.convertToDTO(savedUser);

        }).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
    }
    @Override
    public void deleteUser(String id) {
        Optional<User> user = userDao.findById(UUID.fromString(id));
        if (user.isPresent()) {
            userDao.delete(user.get());
        } else {
            logger.error("User not found with ID: {}", id);
            throw new AppException(ErrorCode.USER_NOT_FOUND);
        }
    }

    @Transactional
    public void changePassword(String userId, PasswordChangeDto passwordChangeDto) {
        User user = userDao.findById(UUID.fromString(userId))
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        // Verify current password
        if (!user.getPasswordHash().equals(passwordChangeDto.getCurrentPassword())) {
            throw new AppException(ErrorCode.INVALID_CURRENT_PASSWORD);
        }

        // Check if new password and confirm password match
        if (!passwordChangeDto.getNewPassword().equals(passwordChangeDto.getConfirmPassword())) {
            throw new AppException(ErrorCode.PASSWORD_MISMATCH);
        }

        // Encode and set new password
        user.setPasswordHash(passwordChangeDto.getNewPassword());
        userDao.save(user);
    }
}
