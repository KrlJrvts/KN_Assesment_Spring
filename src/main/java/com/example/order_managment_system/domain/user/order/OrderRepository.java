package com.example.order_managment_system.domain.user.order;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("select o from Order o where o.submissionDate = ?1")
    List<Order> findAllBy(LocalDate submissionDate);


}