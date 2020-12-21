package com.example.bevarage_service.repository;

import com.example.bevarage_service.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
