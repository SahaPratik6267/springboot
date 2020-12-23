package com.example.bevarage_service.repository;

import com.example.bevarage_service.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {


   // @Query(value = "SELECT * FROM ORDER_ITEM i where i.Orders.id  = 1")
   // public List<OrderItem> findAllByCurrentUser();
}
