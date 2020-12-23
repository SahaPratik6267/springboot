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

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = {"/basket"})

public class CartController {
    List<String> cartItems;
    List<OrderItem> finalItems= new ArrayList<OrderItem>();
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



            List<Bottle> bottleItems = new ArrayList<>();
            cartItems = (List<String>) session.getAttribute("CartSession");
            for (String item:cartItems) {
                bottleItems.add(new Gson().fromJson(item,Bottle.class));
            }
            model.addAttribute("cartSession", bottleItems != null ? bottleItems : new ArrayList<>());
            return "basket";

    }
    @PostMapping(value = "/finalsubmit")
    public String submitOrders(Model model){

        User Dan = new User(null,"DanTheMan", "Man123", LocalDate.of(1991, 10, 12));
       int totalPrice=0;

        Orders createOrders= new Orders();
        for (OrderItem item:finalItems) {

            totalPrice=totalPrice+item.getPrice();

        }
        createOrders.setPrice(totalPrice);
        createOrders.setUser(Dan);

        this.ordersrepo.save(createOrders);

        for (OrderItem item:finalItems) {
            item.setOrders(createOrders);

        }

        orderItemRepository.saveAll(finalItems);

      //  new SessionController().destroySession();



//        model.addAttribute("cartSessionCrate",crateItems);
       // model.addAttribute("cartSession", bottleItems);
        return "orders";
    }


    @PostMapping
    public String submitOrder(Model model, @RequestParam Long bev_id, @RequestParam int bev_quantity, @RequestParam int bev_price){


        OrderItem item = new OrderItem();


       int position=0;
       int quantity = bev_quantity;
       int bprice=bev_price;



       item.setBeverage(new Beverage(bev_id));
       item.setPosition(String.valueOf(position++));
       item.setPrice(bprice);
       item.setQuantity(quantity);
       System.out.println(item);

       finalItems.add(item);


        return "redirect:/basket";
    }
    
}
