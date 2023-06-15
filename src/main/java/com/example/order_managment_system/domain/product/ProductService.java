package com.example.order_managment_system.domain.product;

import com.example.order_managment_system.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Resource
    private ProductRepository productRepository;

    public void validateProductBy(String skuCode) {
        boolean productExists = productRepository.productExistBy(skuCode);
        ValidationService.validateProductSkuCodeIsAvailable(productExists);

    }

    public void createProduct(Product product) {
        productRepository.save(product);
    }
}
