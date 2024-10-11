package com.dnanh01.backend.dto.request;

import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class UserUpdateOrDeleteDto {
    private String id;
    private String displayName;
    private String avatarUrl; // Optional
    private String phoneNumber; // Optional
    private String paymentInformation; // Optional
}
