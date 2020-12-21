package com.example.bevarage_service.Model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor

public class Bottle extends Beverage {

    @NotNull(message = "Name must be set")
    @NotEmpty(message = "Name not there")
    @Pattern(regexp = "^[0-9a-zA-Z]+$")
    private String name;
    @NotNull
    @Pattern(regexp = "(https:\\/\\/).*\\.(?:jpg|gif|png)", message = "Must be a valid URL to a picture.")
    private String bottlePic;
    @Positive(message = "Volume must be greater than zero")
    private double volume;
    private boolean isAlcoholic = false;
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
    @ManyToOne(cascade = CascadeType.ALL)
    private Crate crate;
    @OneToMany(mappedBy = "bottle")
    private List<OrderItem> orderitems;
/*
    public Bottle(Long Id, String name, String bottlePic, double volume, double volumePercent, int price, String supplier, int inStock, Crate crate) {
        super(Id);
        this.name = name;
        this.bottlePic = bottlePic;
        this.volume = volume;
        this.volumePercent = volumePercent;
        if (volumePercent > 0) {
            this.isAlcoholic = true;
        }
        this.price = price;
        this.supplier = supplier;
        this.inStock = inStock;
        this.crate = crate;


    }*/

}
