package com.microservice_prj.user_service.Service;

import com.microservice_prj.user_service.Dto.userResponse;
import com.microservice_prj.user_service.Model.User;
import com.microservice_prj.user_service.Repository.userRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class userService {
    userRepository userRepo;
    public boolean createUser(String username, String password, String email, String phone) {
        User new_user = new User();
        new_user.setUsername(username);
        new_user.setPassword(password);
        new_user.setEmail(email);
        new_user.setPhone(phone);
        userRepo.save(new_user);
        return true;
    }
    public List<userResponse> getAllUser() {
        return userRepo.findAll().stream()
                .map(User -> new userResponse(User.getUsername(), User.getFirstName(), User.getLastName(), User.getEmail())).toList();
    }
    public userResponse getUserById(Long Id) {
        return userRepo.findById(Id).stream().map(User-> new userResponse(User.getUsername(), User.getFirstName(), User.getLastName(), User.getEmail())).toList().get(0);
    }

}
