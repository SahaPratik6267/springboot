package com.example.bevarage_service.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = "/basket")
public class CartController {
    @GetMapping
    public String getBottles(Model model, HttpSession session) {

        List<String> cartItems = (List<String>) session.getAttribute("CartSession");
//        System.out.println(cartItems);
        model.addAttribute("cartSession", cartItems != null ? cartItems : new ArrayList<>());
        return "basket";
    }
    
}
