package com.org.devlogger.api.controller;

import lombok.RequiredArgsConstructor;
import com.org.devlogger.api.domain.User;
import com.org.devlogger.api.dto.UserDto;
import com.org.devlogger.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.security.InvalidParameterException;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserApiController {
    private final UserService userService;

    @PostMapping("/login")
    public User login(@RequestBody UserDto user) throws Exception {
        if(user==null || user.getUsername() == null || user.getPassword() == null){
            throw new AccessDeniedException("Invalid Access");
        }
        return userService.login(user);
    }
    @PostMapping("/signup")
    public User signup(@RequestBody UserDto user) throws Exception {
        log.info("signup user: {}", user);
        if(user==null || user.getUsername() == null || user.getPassword() == null){
            throw new InvalidParameterException("invalid parameter");
        }
        return userService.signup(user);
    }

}
