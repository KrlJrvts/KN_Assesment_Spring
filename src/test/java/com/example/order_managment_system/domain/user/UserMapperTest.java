package com.example.order_managment_system.domain.user;

import com.example.order_managment_system.business.users.UserCreateRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserMapperTest {

    @InjectMocks
    private UserMapper userMapper;

    @Test
    @DisplayName("Should map UserCreateRequest to User correctly")
    void toCreateUserMapping() {
        UserCreateRequest userCreateRequest = new UserCreateRequest(
                "123456", "John Doe", "john.doe@example.com", "1234567890");

        User expectedUser = new User();
        expectedUser.setRegistrationCode(userCreateRequest.getRegistrationCode());
        expectedUser.setFullName(userCreateRequest.getFullName());
        expectedUser.setEmail(userCreateRequest.getEmail());
        expectedUser.setTelephone(userCreateRequest.getTelephone());

        User actualUser = userMapper.toCreateUser(userCreateRequest);

        assertEquals(expectedUser.getRegistrationCode(), actualUser.getRegistrationCode());
        assertEquals(expectedUser.getFullName(), actualUser.getFullName());
        assertEquals(expectedUser.getEmail(), actualUser.getEmail());
        assertEquals(expectedUser.getTelephone(), actualUser.getTelephone());
    }

}