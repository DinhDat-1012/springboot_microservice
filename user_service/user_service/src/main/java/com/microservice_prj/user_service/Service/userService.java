package com.microservice_prj.user_service.Service;

import com.microservice_prj.user_service.Dto.userRequestCreated;
import com.microservice_prj.user_service.Dto.userResponse;
import com.microservice_prj.user_service.Model.User;
import com.microservice_prj.user_service.Repository.userRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class userService {
    private final userRepository userRepo;
    public User createUser(userRequestCreated userRequest) {
        User user = new User();
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        user.setUsername(userRequest.username());
        user.setPassword(bcrypt.encode(userRequest.password()));
        user.setEmail(userRequest.email());
        user.setFirstName(userRequest.firstName());
        user.setLastName(userRequest.lastName());
        user.setAddress(userRequest.address());
        user.setPhone(userRequest.phone());

        return userRepo.save(user);
    }
    public boolean checkPassword(String userName,String password) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        User user = userRepo.findByUsername(userName);
        if(user == null){
            log.info("user not found");
            return false;
        }else{
            log.info("user found [{}]<=>[{}]:[{}]", bcrypt.encode(password),user.getPassword(),bcrypt.matches(bcrypt.encode(password),user.getPassword()));
            return bcrypt.matches(password,user.getPassword());
        }
    }
    public List<userResponse> getAllUser() {
        return userRepo.findAll().stream()
                .map(User -> new userResponse(User.getUsername(), User.getFirstName(), User.getLastName(), User.getEmail())).toList();
    }
    public userResponse getUserById(Long Id) {
        return userRepo.findById(Id).stream().map(User-> new userResponse(User.getUsername(), User.getFirstName(), User.getLastName(), User.getEmail())).toList().get(0);
    }


}
