package com.org.devlogger.api.service;

import lombok.RequiredArgsConstructor;
import com.org.devlogger.api.domain.User;
import com.org.devlogger.api.dto.UserDto;
import com.org.devlogger.api.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User signup(UserDto userDto) {
        User user = User.builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .build();
        return userRepository.save(user);
    }
}
