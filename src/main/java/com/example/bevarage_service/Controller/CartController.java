package com.example.bevarage_service.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "/basket")
public class CartController {
    @GetMapping
    public String getBottles(Model model) {

        return "basket";
    }
}
