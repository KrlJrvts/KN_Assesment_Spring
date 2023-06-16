package com.example.order_managment_system.domain.user.orderline;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
    @Query("select o from OrderLine o where o.orders.id = ?1")
    OrderLine getDateBy(Integer id);

    @Query("select o from OrderLine o where o.products.id = ?1")
    List<OrderLine>  getOrdersByProduct(Integer id);

    @Query("select o from OrderLine o where o.orders.user.id = ?1")
    List<OrderLine> getOrderLinesByUser(Integer id);

    @Query("select o from OrderLine o where o.orders.id = ?1")
    List<OrderLine> getOrderBy(Integer id);






}


