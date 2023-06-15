package com.example.order_managment_system.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select (count(p) > 0) from Product p where p.skuCode = ?1")
    boolean productExistBy(String skuCode);


}