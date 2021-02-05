package com.example.bevarage_service.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "Name must be set")
    @NotEmpty(message = "Name not there")
    private String userName;
    @NotNull(message = "password must be set")
    @NotEmpty(message = "password not there")
    private String password;
    @Past(message = "Birth date must be in the past")
    private LocalDate birthday;
    private boolean active;
    private String roles;
}