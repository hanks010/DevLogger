package com.org.devlogger.api.service;

import com.org.devlogger.api.domain.User;
import com.org.devlogger.api.dto.UserDto;
import com.org.devlogger.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User signup(UserDto userDto) {
        User user = User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .build();
        return userRepository.save(user);
    }

    public User login(UserDto userDto) throws Exception {
        User user = userRepository.findByUsername(userDto.getUsername());
        if (user == null || !passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
            throw new Exception("아이디 또는 비밀번호가 일치하지 않습니다");
        }
        return user;
    }
}
