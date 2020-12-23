package com.example.bevarage_service.repository;

import com.example.bevarage_service.Model.Crate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CrateRepository extends BeverageRepository {
    @Query(value = "SELECT CRATES_IN_STOCK FROM CRATE WHERE ID= ?1" , nativeQuery = true)
    public int findCratestockById(Long Id);
}
