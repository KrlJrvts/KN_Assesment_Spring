package com.example.order_managment_system.business.users;

import com.example.order_managment_system.domain.user.User;
import com.example.order_managment_system.domain.user.UserMapper;
import com.example.order_managment_system.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersService {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @Transactional
    public void createUser(UserCreateRequest userCreateRequest) {
        userService.validateUserBy(userCreateRequest.getEmail());

        User user = userMapper.toCreateUser(userCreateRequest);

        userService.createUser(user);
    }


}
