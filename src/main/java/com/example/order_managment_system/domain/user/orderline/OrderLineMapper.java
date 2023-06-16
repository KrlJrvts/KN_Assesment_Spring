package com.example.order_managment_system.domain.user.orderline;


import com.example.order_managment_system.business.orders.dtos.OrderByProductResponse;
import com.example.order_managment_system.business.orders.dtos.OrderByUserResponse;
import com.example.order_managment_system.business.orders.dtos.OrderLinesCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderLineMapper {

    OrderLine toOrderLine(OrderLinesCreateRequest orderLinesCreateRequest);
    List<OrderLine> toOrderLineList(List<OrderLinesCreateRequest> orderLinesCreateRequests);

    OrderByUserResponse toOrderByUserResponse(OrderLinesCreateRequest orderLinesCreateRequest);
    List<OrderByProductResponse> toOrderByProductResponseList(List<OrderLine> orders);

    OrderByUserResponse toOrderByUserResponse(OrderLine orders);
    List<OrderByUserResponse> toOrderByUserResponseList(List<OrderLine> orders);
}
