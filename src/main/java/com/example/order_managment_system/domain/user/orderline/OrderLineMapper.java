package com.example.order_managment_system.domain.user.orderline;

import com.example.order_managment_system.business.orders.dtos.OrderLinesCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderLineMapper {


    OrderLine toOrderLine(OrderLinesCreateRequest orderLinesCreateRequest);
    List<OrderLine> toOrderLineList(List<OrderLinesCreateRequest> orderLinesCreateRequests);
}
