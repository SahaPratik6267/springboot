package com.example.bevarage_service.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orders")
//@NamedEntityGraphs({
//@NamedEntityGraph(name = "Orders.orderitems.admin",
//        attributeNodes = {
//                @NamedAttributeNode(value = "orderItems", subgraph = "OrderItems.Beverage"),
//                @NamedAttributeNode(value = "users")
//        },
//        subgraphs = {
//                @NamedSubgraph(name = "OrderItems.Beverage", attributeNodes = @NamedAttributeNode("beverage"))
//        }
//
//),

@NamedEntityGraph(name = "Orders.orderitems",
        attributeNodes = {
                @NamedAttributeNode(value = "orderItems", subgraph = "OrderItems.Beverage"),
                @NamedAttributeNode(value = "users")

        },
        subgraphs = {
                @NamedSubgraph(name = "OrderItems.Beverage", attributeNodes = @NamedAttributeNode("beverage"))
        }

)
//})

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Positive(message = "Price must be greater than zero")
    private int price;
    @OneToMany(mappedBy = "orders", fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    private User users;

}
