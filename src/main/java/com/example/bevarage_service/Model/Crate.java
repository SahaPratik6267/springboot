package com.example.bevarage_service.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Crate extends Beverage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "Name must be set")
    @NotEmpty(message = "Name not there")
    @Pattern(regexp = "^[0-9a-zA-Z]+$")
    private String name;
    @NotNull
    @Pattern(regexp = "(https:\\/\\/).*\\.(?:jpg|gif|png)", message = "Must be a valid URL to a picture.")
    private String cratePic;
    @Positive(message = "Number of Bottles must be greater than zero")
    private int noOfBottles;
    @Positive(message = "Price must be greater than zero")
    private int price;
    @PositiveOrZero(message = "Stock can not be less than zero")
    private int cratesInStock;
    @OneToMany(mappedBy = "crate")
    private List<Bottle> bottles;

}
