package com.dnanh01.backend.utils;

import com.dnanh01.backend.model.domain.User;
import com.dnanh01.backend.dto.response.UserResponseDto;

public class UserUtils {
    public static UserResponseDto convertToDTO(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId().toString());
        dto.setEmail(user.getEmail());
        dto.setDisplayName(user.getDisplayName());
        dto.setAvatarUrl(user.getAvatarUrl());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setPaymentInformation(user.getPaymentInformation());
        dto.setRoleName(user.getRole().getRoleName()) ;

        //dto.setVerified(user.getVerified());
        return dto;
    }




}
