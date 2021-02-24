package com.example.bevarage_service.Controller;

import com.example.bevarage_service.Model.*;
import com.example.bevarage_service.repository.*;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
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
    final BottleRepository bottleRepository;
    final CrateRepository crateRepository;
    int position=0;

    public CartController(OrderItemRepository orderItemRepository, AddressRepository addressRepo, UserRepository userrepo, OrdersRepository ordersrepo, BottleRepository bottleRepository, CrateRepository crateRepository) {
        this.orderItemRepository = orderItemRepository;
        this.addressRepo = addressRepo;
        this.userrepo = userrepo;
        this.ordersrepo = ordersrepo;
        this.bottleRepository = bottleRepository;
        this.crateRepository = crateRepository;

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
    public String submitOrders(Model model, HttpServletRequest request){


      //  User Dan = new User(null,"DanTheMan", "Man123", LocalDate.of(1991, 10, 12),null);

        User Dan = new User(null,"DanTheMan", "Man123", LocalDate.of(1991, 10, 12) ,null,null,true,"ADMIN");

       int totalPrice=0;

        Orders createOrders= new Orders();
        for (OrderItem item:finalItems) {

            totalPrice=totalPrice+item.getPrice();

        }
        createOrders.setPrice(totalPrice);
      //  createOrders.setUser(Dan);

        this.ordersrepo.save(createOrders);

        for (OrderItem item:finalItems) {
            item.setOrders(createOrders);

        }

        orderItemRepository.saveAll(finalItems);

        request.getSession().invalidate();

        finalItems.clear();

        return "redirect:/orders";
    }


    @PostMapping
    public String submitOrder(Model model, @RequestParam Long bev_id, @RequestParam int bev_quantity, @RequestParam int bev_price){

        int quantity = bev_quantity;
        int bprice=bev_price*bev_quantity;
        OrderItem item = new OrderItem();

        if(bottleRepository.existsById(bev_id)){
           if  (quantity>bottleRepository.findbottlestockById(bev_id));
            {
                System.out.println("error in quantity");
            }
        }
        else{
            if  (quantity>crateRepository.findCratestockById(bev_id));
            {
                System.out.println("error in quantity");
            }

        }






       item.setBeverage(new Beverage(bev_id));
       item.setPosition(String.valueOf(position++));
       item.setPrice(bprice);
       item.setQuantity(quantity);
       System.out.println(item);

       finalItems.add(item);


        return "redirect:/basket";
    }
    
}
