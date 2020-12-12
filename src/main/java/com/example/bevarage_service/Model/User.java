package com.example.bevarage_service.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class User {
    private String username;
    private String password;
    private LocalDate birthday;
}