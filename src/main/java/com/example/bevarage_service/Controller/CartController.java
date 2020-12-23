package com.example.bevarage_service.Controller;

import com.example.bevarage_service.Model.*;
import com.example.bevarage_service.repository.AddressRepository;
import com.example.bevarage_service.repository.OrderItemRepository;
import com.example.bevarage_service.repository.OrdersRepository;
import com.example.bevarage_service.repository.UserRepository;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = "/basket")
public class CartController {
    List<String> cartItems;
    final OrderItemRepository orderItemRepository;
    final AddressRepository addressRepo;
    final UserRepository userrepo;
    final OrdersRepository ordersrepo;

    public CartController(OrderItemRepository orderItemRepository, AddressRepository addressRepo, UserRepository userrepo, OrdersRepository ordersrepo) {
        this.orderItemRepository = orderItemRepository;
        this.addressRepo = addressRepo;
        this.userrepo = userrepo;
        this.ordersrepo = ordersrepo;
    }

    @GetMapping
    public String getBottles(Model model, HttpSession session) {


        List<OrderItem> orderItems= new ArrayList<>();
         cartItems = (List<String>) session.getAttribute("CartSession");
        System.out.println(cartItems);

        for (String item:cartItems) {
            orderItems.add(new Gson().fromJson(item,OrderItem.class));
             }

        System.out.println();
        model.addAttribute("cartSession", cartItems != null ? cartItems : new ArrayList<>());
        return "basket";
    }
    @PostMapping
    public String submitOrders(Model model){
        Address firstAddress = new Address(3L, "Baker Street", "22A", "96047");
        Address secondAddress = new Address(4L, "Pasadena", "4C", "96052");

        this.addressRepo.saveAll(Arrays.asList(firstAddress, secondAddress));
        //User Dan = new User(3L, "DanTheMan", "Man123", LocalDate.of(1991, 10, 12),new ArrayList<>(Arrays.asList(secondAddress, firstAddress)));

       

        List<OrderItem> orderItems= new ArrayList<>();

       // cartItems = (List<String>) session.getAttribute("CartSession");
        List<Bottle> bottleItems = new ArrayList<>();
        List<Crate> crateItems = new ArrayList<>();


        for (String item:cartItems) {
            bottleItems.add(new Gson().fromJson(item, Bottle.class));
//            crateItems.add(new Gson().fromJson(item, Crate.class));
        }

        Orders createOrders= new Orders();
        createOrders.setPrice(100);
       // createOrders.setUser(Dan);

        this.ordersrepo.save(createOrders);

        for (OrderItem item:orderItems) {
            item.setOrders(createOrders);

        }



//        model.addAttribute("cartSessionCrate",crateItems);
        model.addAttribute("cartSession", bottleItems);
        return "basket";
    }


    @PostMapping
    public String submitOrders(Model model, @RequestParam Long bev_id, @RequestParam String bev_quantity){
//        Address firstAddress = new Address(3L, "Baker Street", "22A", "96047", null);
//        Address secondAddress = new Address(4L, "Pasadena", "4C", "96052", null);
//
//        this.addressRepo.saveAll(Arrays.asList(firstAddress, secondAddress));
//        User Dan = new User(3L, "DanTheMan", "Man123", LocalDate.of(1991, 10, 12),new ArrayList<>(Arrays.asList(secondAddress, firstAddress)));

       long id= bev_id;
       String quantity = bev_quantity;

//        List<OrderItem> orderItems= new ArrayList<>();
//
//        for (String item:cartItems) {
//            orderItems.add(new Gson().fromJson(item,OrderItem.class));
//        }
//        Orders createOrders= new Orders();
//        createOrders.setPrice(100);
//        createOrders.setUser(Dan);
//
//        this.ordersrepo.save(createOrders);
//
//        for (OrderItem item:orderItems) {
//            item.setOrders(createOrders);
//
//        }
//
//
//
//        this.orderItemRepository.saveAll(orderItems);

        return "orders";
    }
    
}
