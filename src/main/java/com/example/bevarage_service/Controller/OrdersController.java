package com.example.bevarage_service.Controller;

import com.example.bevarage_service.Model.Orders;
import com.example.bevarage_service.repository.OrderItemRepository;
import com.example.bevarage_service.repository.OrdersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Scanner;

@Controller
@RequestMapping(value = "/orders")
public class OrdersController {

    private final OrdersRepository ordersRepository;
    private final OrderItemRepository orderItemRepository;
    public OrdersController(OrdersRepository ordersRepository, OrderItemRepository orderItemRepository){
        this.ordersRepository = ordersRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @GetMapping
    public String getOrdersByUserID(Model model) {
        Orders orders = new Orders();
//        model.addAttribute("orders", orders);
//        model.addAttribute("Orders",this.ordersRepository.findAll());
        model.addAttribute("Orders",this.orderItemRepository.findAll());


        return "orders";
    }
}
