package com.dnanh01.backend.service.iface;

import com.dnanh01.backend.dto.request.PasswordChangeDto;
import com.dnanh01.backend.dto.request.UserRegistrationDto;
import com.dnanh01.backend.dto.request.UserUpdateOrDeleteDto;
import com.dnanh01.backend.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto addUser(UserRegistrationDto userRegistrationDto);
//    void deleteUser(String username);
//    void updateUser(String username, String password);
//    void getUser(String username);
//    void getAllUsers();

    List<UserResponseDto> getAllUsers();

    UserResponseDto getUser(String id);

    void deleteUser(String id);

    UserResponseDto updateUser(String id, UserUpdateOrDeleteDto userUpdateOrDeleteDto);
    void changePassword(String userId, PasswordChangeDto passwordChangeDto);
}
