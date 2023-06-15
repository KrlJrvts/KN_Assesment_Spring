package com.example.order_managment_system.domain.user.order;

import com.example.order_managment_system.business.orders.dtos.OrderByDateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    @Mapping(source = "user.fullName", target = "fullName")
    OrderByDateResponse toOrderByDateResponse(Order order);

    List<OrderByDateResponse> toOrderByDateResponseList(List<Order> orders);
}
