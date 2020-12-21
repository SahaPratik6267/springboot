package com.example.bevarage_service.repository;

import com.example.bevarage_service.Model.Bottle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BottleRepository extends JpaRepository<Bottle, Long> {
}
