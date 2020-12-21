package com.example.bevarage_service.repository;

import com.example.bevarage_service.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
