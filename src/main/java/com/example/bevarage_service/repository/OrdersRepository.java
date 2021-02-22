package com.example.bevarage_service.repository;

import com.example.bevarage_service.Model.*;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrdersRepository extends JpaRepository<Orders, Long> {




   //@EntityGraph(value = "Orders.orderItems", attributePaths = {"orderItems"})
   @EntityGraph(value = "Orders.orderitems")
   List<Orders> findAllByusers(User user);


}
