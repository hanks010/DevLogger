package com.org.devlogger.api.controller;

import lombok.RequiredArgsConstructor;
import com.org.devlogger.api.domain.User;
import com.org.devlogger.api.dto.UserDto;
import com.org.devlogger.api.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.security.InvalidParameterException;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) throws Exception {
        if(username != null && password != null){
            return "success";
        }
        throw new AccessDeniedException("Invalid Access");
    }
    @PostMapping("/signup")
    public User signup(@RequestBody UserDto user) throws Exception {
        System.out.println(user.toString());
        if(user==null || user.getUsername() == null || user.getPassword() == null){
            throw new InvalidParameterException("invalid parameter");
        }
        return userService.signup(user);
    }

}
