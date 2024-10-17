package com.microservice_prj.user_service.Controller;

import com.microservice_prj.user_service.Dto.*;
import com.microservice_prj.user_service.Model.User;
import com.microservice_prj.user_service.Repository.userRepository;
import com.microservice_prj.user_service.Service.userService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/api/user")
@RequiredArgsConstructor
public class userController {
    private final userService UserService;
    private final userRepository UserRepo;
    @PostMapping(path= "/add-user")
    @ResponseStatus(HttpStatus.CREATED)
    //then it should be moved to service!!
    public ResponseEntity<userResponse> CreateUser(@RequestBody userRequestCreated userRequest){
        if(UserRepo.findByEmail(userRequest.email())==null && UserRepo.findByUsername(userRequest.username())==null){
            User userTransfer = UserService.createUser(userRequest);
            log.info("User created: " + userTransfer.toString());
            return ResponseEntity.status(HttpStatus.CREATED).body(new userResponse(
                    userTransfer.getUsername(),
                    userTransfer.getFirstName(),
                    userTransfer.getLastName(),
                    userTransfer.getEmail()));
        }else{
            log.info("User or email already exists=> created user account failed!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @PostMapping(path = "/check-password")
        @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<userCheckPasswordResponse> checkPassword(@RequestBody userCheckPasswordRequest userCheckPasswordRequest) {
        if (UserService.checkPassword(userCheckPasswordRequest.userName(), userCheckPasswordRequest.password())) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new userCheckPasswordResponse("True", "ACCEPTED"));
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new userCheckPasswordResponse("False", "DENIED"));
        }
    }
    @PostMapping(path = "/change_password")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> changePassword(@RequestBody userChangePasswordRequest UserChangePasswordRequest){
        return ResponseEntity.status(200).body("We will do it tomorrow");
    }
}

