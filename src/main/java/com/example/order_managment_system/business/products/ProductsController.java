package com.example.order_managment_system.business.products;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Resource
    private ProductsService productsService;

    @PostMapping("/create")
    @Operation(summary = "Create product",
            description = "Product is added to database based on name, skuCode, unitPrice")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product created successfully"),
            @ApiResponse(responseCode = "403", description = "Product already exists")})
    public void createProduct(@RequestBody ProductCreateRequest productCreateRequest) {
        productsService.createProduct(productCreateRequest);
    }


}
