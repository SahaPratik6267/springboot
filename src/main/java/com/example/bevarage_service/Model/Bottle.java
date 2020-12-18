package com.example.bevarage_service.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class Bottle {
    private long id;
    @NotEmpty
    private String name;
    private String bottlePic;
    private double volume;
    private boolean isAlcoholic;
    private double volumePercent;
    private int price;
    private String supplier;
    private int inStock;

}
