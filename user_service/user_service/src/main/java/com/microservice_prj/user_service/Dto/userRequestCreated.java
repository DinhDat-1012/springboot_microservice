package com.microservice_prj.user_service.Dto;

public record userRequestCreated(
         String username,
         String password,
         String firstName,
         String lastName,
         String email,
         String phone,
         String address) {
}
