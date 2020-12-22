package com.example.bevarage_service.Controller;

import com.example.bevarage_service.Model.Bottle;
import com.example.bevarage_service.Model.Crate;
import com.example.bevarage_service.repository.BottleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = "/beverage")
public class BeverageController {
    private final List<Bottle> bottleList;
    private final List<Crate> crateList;

    public BeverageController(BottleRepository bottleRepository) {
        this.bottleList = new ArrayList<>();
        this.crateList = new ArrayList<>();

    }


    @GetMapping
    public String getBottles(Model model) {
        model.addAttribute("Bottles", this.bottleList);

        model.addAttribute("Crates", this.crateList);

        return "beverage";
    }


//    @PostMapping
//    public String addBottles(@Valid Bottle bottle, Errors errors, Model model){
//
//        if (errors.hasErrors()){
//            model.addAttribute("Bottles", this.bottleRepository.findAll());
//            return "beverage";
//        }
//        //bottle.setId("" + this.bottleRepository.count()+1);
//        this.bottleRepository.save(bottle);
//
//        return "redirect:/beverage";
//    }

}
