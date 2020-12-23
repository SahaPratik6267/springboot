package com.example.bevarage_service.repository;

import com.example.bevarage_service.Model.Bottle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BottleRepository extends BeverageRepository {
    @Query(value = "SELECT IN_STOCK FROM BOTTLE WHERE ID= ?1",nativeQuery = true)
    public int findbottlestockById(Long Id);
}
