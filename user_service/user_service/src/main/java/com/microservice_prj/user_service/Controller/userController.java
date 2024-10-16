package com.microservice_prj.user_service.Controller;

import com.microservice_prj.user_service.Service.userService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/api/user")
@Controller
@RequiredArgsConstructor
public class userController {
    userService UserService;

}
