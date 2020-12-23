package com.example.bevarage_service.repository;

import com.example.bevarage_service.Model.Orders;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {


    @Query(value = "SELECT * FROM ORDERS WHERE USER_ID= ?1", nativeQuery = true)
    List<Orders> findAllByUserID(Long Id);

}
