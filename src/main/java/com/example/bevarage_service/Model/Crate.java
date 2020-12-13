package com.example.bevarage_service.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Crate {
    private long id;
    private  String name;
    private String cratePic;
    private int noOfBottles;
    private double price;
    private int cratesInStock;

}
