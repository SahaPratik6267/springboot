package com.example.bevarage_service.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;
import java.util.List;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Crate extends Beverage {

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

   
    public Crate(String name, String cratePic, int noOfBottles, int price, int cratesInStock) {


        this.name = name;
        this.cratePic = cratePic;
        this.noOfBottles = noOfBottles;
        this.price = price;
        this.cratesInStock = cratesInStock;


    }

}
