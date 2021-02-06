package com.example.bevarage_service.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.domain.Sort;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedEntityGraph(name= "OrderItem.orders", attributeNodes = @NamedAttributeNode("orders"))
//@NamedQuery(name = "OrderItem.findAllByCurrentUser",query = "select u from OrderItem u where u.orders.id = 1")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Pattern(regexp = "^[0-9]*$")
    private String position;
    @Positive(message = "Price must be greater than zero")
    private int price;
    @Positive(message = "Quantity must be greater than zero")
    private int quantity;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Orders orders;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Beverage beverage;
}


