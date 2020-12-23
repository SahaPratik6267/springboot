package com.example.bevarage_service.Controller;

import com.example.bevarage_service.Model.Beverage;
import com.example.bevarage_service.Model.Bottle;
import com.example.bevarage_service.Model.Crate;
import com.example.bevarage_service.Model.OrderItem;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SessionController {
    @PostMapping("/addToCart")
    public String addToCart(@RequestParam Long b_id, @RequestParam String b_name, @RequestParam int b_price, HttpServletRequest request) {

        List<String> cartItems = (List<String>) request.getSession().getAttribute("CartSession");

        if (cartItems == null) {
            cartItems = new ArrayList<>();
            // if cartItems object is not present in session, set cartItems in the request session
            request.getSession().setAttribute("CartSession", cartItems);
        }

        Bottle bev= new Bottle();
        bev.setId(b_id);
        bev.setName(b_name);
        bev.setPrice(b_price);


        cartItems.add(new Gson().toJson(bev));
        request.getSession().setAttribute("CartSession", cartItems);


        return "redirect:/beverage";
    }

    @PostMapping("/addToCartCrate")
    public String addToCartCrate(@RequestParam Long c_id, @RequestParam String c_name, @RequestParam int c_price, HttpServletRequest request) {

        List<String> cartItems = (List<String>) request.getSession().getAttribute("CartSession");

        if (cartItems == null) {
            cartItems = new ArrayList<>();
            // if cartItems object is not present in session, set cartItems in the request session
            request.getSession().setAttribute("CartSession", cartItems);
        }

        Crate bev = new Crate();
        bev.setId(c_id);
        bev.setName(c_name);
        bev.setPrice(c_price);


        cartItems.add(new Gson().toJson(bev));
        request.getSession().setAttribute("CartSession", cartItems);


        return "redirect:/beverage";
    }

    @PostMapping("/invalidate/session")
    public String destroySession(HttpServletRequest request) {
        //invalidate the session , this will clear the data from configured database (Mysql/redis/hazelcast)

        request.getSession().invalidate();
        return "redirect:/beverage";
    }

}
