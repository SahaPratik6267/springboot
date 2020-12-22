package com.example.bevarage_service.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderItem {
    @Id
    private Long id;
    @Pattern(regexp = "^[0-9]*$")
    private String position;
    @Positive(message = "Price must be greater than zero")
    private int price;
    @Positive(message = "Quantity must be greater than zero")
    private int quantity;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Orders orders;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Bottle bottle;
}


