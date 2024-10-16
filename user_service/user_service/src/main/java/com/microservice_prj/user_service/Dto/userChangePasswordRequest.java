package com.microservice_prj.user_service.Dto;

public record userChangePasswordRequest(
        String userName,
        String email,
        String oldPassword,
        String newPassword
) {}
