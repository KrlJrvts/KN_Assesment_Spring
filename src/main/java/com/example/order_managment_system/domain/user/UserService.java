package com.example.order_managment_system.domain.user;

import com.example.order_managment_system.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public void validateUserBy(String email) {
        boolean userExists = userRepository.userExistBy(email);
        ValidationService.validateUserEmailIsAvailable(userExists);
    }

    public void createUser(User user) {
        userRepository.save(user);
    }
}
