package com.example.bevarage_service.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @PostMapping(value = "/loginsubmit")
    public String userlogin(String username, String password, Model model) {

        return "login";
    }
}
