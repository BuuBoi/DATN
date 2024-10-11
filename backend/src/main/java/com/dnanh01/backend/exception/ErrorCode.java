package com.dnanh01.backend.exception;

public enum ErrorCode {
    USER_NOT_FOUND(1001, "User not found."),
    USER_ALREADY_EXISTS(1002, "User already exists."),
    ROLE_NOT_FOUND(1003, "Role not found."),
    ROLE_ALREADY_EXISTS(1004, "Role already exists."),
    Email_ALREADY_EXISTS(1005, "Email already exists."),
    INVALID_CURRENT_PASSWORD(1006, "Invalid current password."),
    PASSWORD_MISMATCH(1007, "Password mismatch."),
    INVALID_EMAIL(1008, "Email is not in correct format."),
    INVALID_PASSWORD(1009, "Password must be at least 6 characters long."),
    INVALID_DISPLAY_NAME(1010, "Display name must be at least 6 characters long."),
    EMAIL_OR_PASSWORD_NOT_FOUND(1011, "Email or password not found."),
    INVALID_ADDRESS(1012, "Invalid address."),
    ADDRESS_NOT_FOUND(1013, "Address not found."),

    UNCATALOGUED(9999, "Uncatalogued error."),
    INVALID_KEY(1000, "Invalid key."), //kiem tra Key hop le
    ;
    private int code;
    private String message;

    ErrorCode(int i, String s) {
        this.code = i;
        this.message = s;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
