package com.example.order_managment_system.domain.user;

import com.example.order_managment_system.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;


    public void createUser(User user) {
        userRepository.save(user);
    }



    public void validateUserBy(String email) {
        boolean userExists = userRepository.userExistBy(email);
        ValidationService.validateUserEmailIsAvailable(userExists);
    }



    public User getUserById(Integer user) {
        return userRepository.findById(user).get();
    }
}
