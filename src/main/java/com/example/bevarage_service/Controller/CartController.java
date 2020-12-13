package com.example.bevarage_service.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/basket")
public class CartController {
    @GetMapping
    public String getBottles(Model model) {

        return "basket";
    }
}
