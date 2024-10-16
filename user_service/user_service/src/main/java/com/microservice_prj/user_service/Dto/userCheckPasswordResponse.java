package com.microservice_prj.user_service.Dto;

public record userCheckPasswordResponse(
        String result,
        String message
) { }
