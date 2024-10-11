package com.dnanh01.backend.controller;

import com.dnanh01.backend.dto.request.PasswordChangeDto;
import com.dnanh01.backend.dto.request.UserRegistrationDto;
import com.dnanh01.backend.dto.request.UserUpdateOrDeleteDto;
import com.dnanh01.backend.dto.response.ApiResponse;
import com.dnanh01.backend.dto.response.UserResponseDto;
import com.dnanh01.backend.service.iface.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ApiResponse<UserResponseDto> register(@RequestBody @Valid UserRegistrationDto userRegistrationDto) {
        ApiResponse<UserResponseDto> response = new ApiResponse<>();
        response.setStatus(HttpStatus.OK.value());
        response.setData(userService.addUser(userRegistrationDto));
        return response;

    }

    @GetMapping
    public ApiResponse<List<UserResponseDto>> getAllUsers() {
        ApiResponse<List<UserResponseDto>> response = new ApiResponse<>();
        response.setStatus(200);
        response.setData(userService.getAllUsers());
        return response;
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponseDto> getUser(@PathVariable String id) {
        ApiResponse<UserResponseDto> response = new ApiResponse<>();
        response.setStatus(200);
        response.setData(userService.getUser(id));
        return response;
    }
    @PutMapping("/{id}")
    public ApiResponse<UserResponseDto> updateUser(@PathVariable String id, @RequestBody @Valid UserUpdateOrDeleteDto userUpdateOrDeleteDto) {
        ApiResponse<UserResponseDto> response = new ApiResponse<>();
        response.setStatus(200);
        response.setData(userService.updateUser(id, userUpdateOrDeleteDto));
        return response;
    }

    @PutMapping("/{id}/change-password")
    public ApiResponse<String> changePassword(@PathVariable String id, @RequestBody @Valid PasswordChangeDto passwordChangeDto) {
        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus(200);
        userService.changePassword(id, passwordChangeDto);
        response.setMessage("Change password successfully");
        return response;
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteUser(@PathVariable String id) {
        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus(200);
        response.setMessage("Delete user successfully");
        userService.deleteUser(id);
        return response;
    }
}
