package com.example.bevarage_service.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {
    @Id
    private Long id;
    @Positive(message = "Price must be greater than zero")
    private int price;
    @OneToMany(mappedBy = "orders", orphanRemoval = true)
    private List<OrderItem> orderitems;
    @ManyToOne(cascade = CascadeType.MERGE)
    private User user;
}
