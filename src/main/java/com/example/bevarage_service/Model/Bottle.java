package com.example.bevarage_service.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.*;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
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

    public Bottle(@NotNull(message = "Name must be set") @NotEmpty(message = "Name not there") @Pattern(regexp = "^[0-9a-zA-Z]+$") String name, @NotNull @Pattern(regexp = "(https:\\/\\/).*\\.(?:jpg|gif|png)", message = "Must be a valid URL to a picture.") String bottlePic, @Positive(message = "Volume must be greater than zero") double volume, @PositiveOrZero double volumePercent, @Positive(message = "Price must be greater than zero") int price, @NotNull(message = "Supplier name must be set") @NotEmpty(message = "Supplier name not there") String supplier, @PositiveOrZero(message = "Stock can not be less than zero") int inStock) {
        super();
        this.name = name;
        this.bottlePic = bottlePic;
        this.volume = volume;
        this.volumePercent = volumePercent;
        if (volumePercent > 0.0) {
            this.isAlcoholic = true;
        } else {
            this.isAlcoholic = false;
        }
        this.price = price;
        this.supplier = supplier;
        this.inStock = inStock;
    }
}
