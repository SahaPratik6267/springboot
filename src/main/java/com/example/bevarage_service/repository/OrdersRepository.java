package com.example.bevarage_service.repository;

import com.example.bevarage_service.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

}
