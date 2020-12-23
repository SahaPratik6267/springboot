package com.example.bevarage_service.Controller;

import com.example.bevarage_service.Model.OrderItem;
import com.example.bevarage_service.repository.OrderItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "orders")
public class OrdersController {

    public List<OrderItem> orderItems;
    final OrderItemRepository orderItemRepository;

    public OrdersController(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }


    @GetMapping
    public String getOrdersByUserID() {
       // orderItems=orderItemRepository.findAllByCurrentUser();

       //System.out.println(orderItems);


        return "orders";
    }
}
