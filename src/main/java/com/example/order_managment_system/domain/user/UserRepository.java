package com.example.order_managment_system.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select (count(u) > 0) from User u where u.email = ?1")
    boolean userExistBy(String email);
}