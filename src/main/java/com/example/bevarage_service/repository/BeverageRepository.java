package com.example.bevarage_service.repository;

import com.example.bevarage_service.Model.Beverage;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface BeverageRepository extends JpaRepository<Beverage, Long>{
}
