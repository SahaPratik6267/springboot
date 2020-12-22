package com.example.bevarage_service.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Crate extends Beverage{
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
    @ManyToOne(cascade = CascadeType.MERGE)
    private Bottle bottles;

    public Crate( @NotNull(message = "Name must be set") @NotEmpty(message = "Name not there") @Pattern(regexp = "^[0-9a-zA-Z]+$") String name, @NotNull @Pattern(regexp = "(https:\\/\\/).*\\.(?:jpg|gif|png)", message = "Must be a valid URL to a picture.") String cratePic, @Positive(message = "Number of Bottles must be greater than zero") int noOfBottles, @Positive(message = "Price must be greater than zero") int price, @PositiveOrZero(message = "Stock can not be less than zero") int cratesInStock, Bottle bottles) {
        super();
        this.name = name;
        this.cratePic = cratePic;
        this.noOfBottles = noOfBottles;
        this.price = price;
        this.cratesInStock = cratesInStock;
        this.bottles = bottles;
    }
}
