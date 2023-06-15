package com.example.order_managment_system.domain.product;

import com.example.order_managment_system.business.products.ProductCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
    Product toCreateProduct(ProductCreateRequest productCreateRequest);
}
