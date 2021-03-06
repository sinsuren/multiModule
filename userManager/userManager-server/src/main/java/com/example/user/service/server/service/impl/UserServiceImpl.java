package com.example.user.service.server.service.impl;

import com.example.user.manager.datatypes.CreateUserRequest;
import com.example.user.manager.datatypes.UserState;
import com.example.user.service.server.entity.User;
import com.example.user.service.server.repository.UserRepository;
import com.example.user.service.server.service.UserService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(String userId) {
        return userRepository.findUserByUserId(userId);
    }

    @Override
    public User createUser(CreateUserRequest request) {
        User user = new User();

        user.setGender(request.getGender());
        user.setUserId(request.getUserId());
        user.setAge(request.getAge());
        user.setName(request.getName());
        user.setUserState(UserState.UN_VERIFIED);
        user.setCreatedAt(new DateTime());
        user.setCreatedBy(request.getName());

        return userRepository.save(user);
    }
}
