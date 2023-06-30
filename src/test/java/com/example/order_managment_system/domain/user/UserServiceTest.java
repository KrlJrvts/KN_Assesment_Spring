package com.example.order_managment_system.domain.user;

import com.example.order_managment_system.validation.ValidationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ValidationService validationService;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() {
        User user = new User();
        doNothing().when(userRepository).save(user);

        userService.createUser(user);

        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testValidateUserBy_ValidUserEmail() {
        String email = "test@example.com";
        when(userRepository.userExistBy(email)).thenReturn(false);
        doNothing().when(validationService).validateUserEmailIsAvailable(false);

        userService.validateUserBy(email);

        verify(userRepository, times(1)).userExistBy(email);
        verify(validationService, times(1)).validateUserEmailIsAvailable(false);
    }

    @Test
    void testValidateUserBy_InvalidUserEmail() {
        String email = "test@example.com";
        when(userRepository.userExistBy(email)).thenReturn(true);
        doNothing().when(validationService).validateUserEmailIsAvailable(true);

        userService.validateUserBy(email);

        verify(userRepository, times(1)).userExistBy(email);
        verify(validationService, times(1)).validateUserEmailIsAvailable(true);
    }

    @Test
    void testGetUserById() {
        Integer userId = 1;
        User user = new User();
        when(userRepository.findById(userId)).thenReturn(java.util.Optional.of(user));

        User result = userService.getUserById(userId);

        verify(userRepository, times(1)).findById(userId);
        assertEquals(user, result);
    }
}
