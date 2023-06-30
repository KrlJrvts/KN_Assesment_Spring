package com.example.order_managment_system.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("Should return false when the user does not exist by email")
    void userExistByEmailWhenUserDoesNotExist() {
        String email = "test@example.com";
        when(userRepository.userExistBy(email)).thenReturn(false);

        boolean result = userRepository.userExistBy(email);

        assertFalse(result);
        verify(userRepository, times(1)).userExistBy(email);
    }

    @Test
    @DisplayName("Should return true when the user exists by email")
    void userExistByEmailWhenUserExists() {
        String email = "test@example.com";
        when(userRepository.userExistBy(email)).thenReturn(true);

        boolean result = userRepository.userExistBy(email);

        assertTrue(result);
        verify(userRepository, times(1)).userExistBy(email);
    }

}