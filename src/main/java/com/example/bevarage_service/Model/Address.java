package com.example.bevarage_service.Model;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    private Long id;
    private String street;
    private String number;
    private String postalCode;
}
