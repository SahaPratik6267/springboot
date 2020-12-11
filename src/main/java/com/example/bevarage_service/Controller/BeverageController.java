package com.example.bevarage_service.Controller;

import com.example.bevarage_service.Model.Bottle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/beverage")

public class BeverageController {
    private List<Bottle> bottleList;

    public BeverageController() {
        this.bottleList = new ArrayList<>();

        this.bottleList.add(new Bottle(1, "beer", "hellow", 5.5, true, 9.5, 2, "hasib", 5));
    }


    @GetMapping
    public String getBottles(Model model) {

        model.addAttribute("Bottles", this.bottleList);

        return "beverage";
    }
}
