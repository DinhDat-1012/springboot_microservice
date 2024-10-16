package com.microservice_prj.user_service.Dto;

public record userCheckPasswordRequest(
        String userName,
        String password
) {}
