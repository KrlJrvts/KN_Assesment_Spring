package com.example.order_managment_system.business.products;

import com.example.order_managment_system.domain.product.Product;
import com.example.order_managment_system.domain.product.ProductMapper;
import com.example.order_managment_system.domain.product.ProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {

    @Resource
    private ProductService productService;

    @Resource
    private ProductMapper productMapper;

    public void createProduct(ProductCreateRequest productCreateRequest) {
        productService.validateProductBy(productCreateRequest.getSkuCode());

        Product product = productMapper.toCreateProduct(productCreateRequest);

        productService.createProduct(product);

    }
}
