package com.example.order_managment_system.domain.user;

import com.example.order_managment_system.business.users.UserCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    User toCreateUser(UserCreateRequest userCreateRequest);
}
