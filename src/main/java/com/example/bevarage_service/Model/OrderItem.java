package com.example.bevarage_service.Model;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItem {
    private Long id;
    private String position;
    private double price;
}


