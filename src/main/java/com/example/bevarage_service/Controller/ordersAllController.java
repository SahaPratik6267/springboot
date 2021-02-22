package com.example.bevarage_service.Controller;

import com.example.bevarage_service.Model.OrderItem;
import com.example.bevarage_service.Model.Orders;
import com.example.bevarage_service.Model.User;
import com.example.bevarage_service.repository.OrderItemRepository;
import com.example.bevarage_service.repository.OrdersRepository;
import com.example.bevarage_service.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping(value = {"ordersAll"})

public class ordersAllController {

    public List<Orders> orders= new ArrayList<>();
    final OrderItemRepository orderItemRepository;
    final OrdersRepository ordersRepository;
    final UserRepository userRepository;


    public ordersAllController(OrderItemRepository orderItemRepository, OrdersRepository ordersRepository, UserRepository userRepository) {
        this.orderItemRepository = orderItemRepository;
        this.ordersRepository = ordersRepository;
        this.userRepository = userRepository;
    }


    @GetMapping
    public String getOrdersByUserID(Model model) throws IllegalAccessException, InstantiationException {

        System.out.println("wghatsghkjhsf");
        List<User> users = userRepository.findAll();

        for (User user:users
             ) {
            orders.addAll(ordersRepository.findAllByusers(user));

        }
//            orders= ordersRepository.findAllByUsers(users);


            model.addAttribute("orders",this.orders);

            return "ordersall";


    }
}
