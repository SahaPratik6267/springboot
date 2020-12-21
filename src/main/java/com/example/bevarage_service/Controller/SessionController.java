package com.example.bevarage_service.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.bevarage_service.Model.Bottle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SessionController {
    @PostMapping("/addToCart")
    public String addToCart(@RequestParam String b_name, @RequestParam int b_price, HttpServletRequest request) {
        //get the cartItems from request session
        List<String> cartItems = (List<String>) request.getSession().getAttribute("CartSession");
        //check if cartItems is present in session or not
        if (cartItems == null) {
            cartItems = new ArrayList<>();
            // if cartItems object is not present in session, set cartItems in the request session
            request.getSession().setAttribute("CartSession", cartItems);
        }
        cartItems.add(b_name);
        cartItems.add(String.valueOf(b_price));
        request.getSession().setAttribute("CartSession", cartItems);
        return "redirect:/beverage";
    }


    @PostMapping("/invalidate/session")
    public String destroySession(HttpServletRequest request) {
        //invalidate the session , this will clear the data from configured database (Mysql/redis/hazelcast)
        request.getSession().invalidate();
        return "redirect:/basket";
    }

}
