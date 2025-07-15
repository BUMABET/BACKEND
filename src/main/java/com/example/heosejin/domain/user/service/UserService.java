package com.example.heosejin.domain.user.service;

import com.example.heosejin.domain.auth.dto.response.GoogleUserInfoResponse;
import com.example.heosejin.domain.user.exception.AlreadyExsistsUserException;
import com.example.heosejin.domain.user.mapper.UserMapper;
import com.example.heosejin.domain.user.model.User;
import com.example.heosejin.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public User googleLogin(GoogleUserInfoResponse googleUserInfoResponse) {
        User user = userMapper.toUser(googleUserInfoResponse);
        Boolean exsistsUser = userRepository.existsById(user.getUserId());
        if (!exsistsUser) userRepository.save(user);
        return user;
    }
}
