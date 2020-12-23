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
//@NamedEntityGraph(name = "Orders.users", // entity graph solution
 //       attributeNodes = @NamedAttributeNode(value="user")) // entity graph solution// entity graph solution
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Positive(message = "Price must be greater than zero")
    private int price;
 //   @OneToMany(mappedBy = "orders")
  //  private List<OrderItem> orderitems;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
}
