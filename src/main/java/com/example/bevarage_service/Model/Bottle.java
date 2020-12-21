package com.example.bevarage_service.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Bottle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "Name must be set")
    @NotEmpty(message = "Name not there")
    @Pattern(regexp = "^[0-9a-zA-Z]+$")
    private String name;
    @NotNull
    @Pattern(regexp = "(https:\\/\\/).*\\.(?:jpg|gif|png)", message = "Must be a valid URL to a picture.")
    private String bottlePic;
    @Positive(message = "Volume must be greater than zero")
    private double volume;
    private boolean isAlcoholic;
    //Have to implement further logic to set the is Alcoholic value when volumePercent is zero
    @PositiveOrZero
    private double volumePercent;
    @Positive(message = "Price must be greater than zero")
    private int price;
    @NotNull(message = "Supplier name must be set")
    @NotEmpty(message = "Supplier name not there")
    private String supplier;
    @PositiveOrZero(message = "Stock can not be less than zero")
    private int inStock;
    @ManyToOne (cascade = CascadeType.MERGE)
    private Crate crate;

}
