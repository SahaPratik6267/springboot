package com.example.bevarage_service.repository;

import com.example.bevarage_service.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT TOP '1' * FROM USER", nativeQuery = true)
    public User findAUser();
}
