package com.example.bevarage_service.Controller;

import com.example.bevarage_service.Model.Bottle;
import com.example.bevarage_service.Model.Crate;
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

    public BeverageController() {
        this.bottleList = new ArrayList<>();
        this.crateList = new ArrayList<>();

//        this.bottleList.add(new Bottle(1, "beer", "https://cdn.pixabay.com/photo/2014/08/10/18/06/beer-414914_960_720.jpg", 5.5, true, 9.5, 2, "hasib", 5));
//        this.bottleList.add(new Bottle(2, "cola", "https://cdn.pixabay.com/photo/2014/09/26/19/51/drink-462776_960_720.jpg", 2, false, 0, 1, "shoiab", 10));
//
//        this.crateList.add(new Crate(1, "crate", "https://cdn.pixabay.com/photo/2017/03/12/18/24/beer-holder-2137721_960_720.jpg", 6, 10, 15));
//        this.crateList.add(new Crate(2, "crate cola", "https://thumbs.dreamstime.com/z/vintage-drink-coca-cola-crate-bottles-product-shot-full-nostalgic-coke-item-soda-44113746.jpg", 10, 15, 10));
    }


    @GetMapping
    public String getBottles(Model model) {

        model.addAttribute("Bottles", this.bottleList);

        model.addAttribute("Crates", this.crateList);

        // model.addAttribute(new Bottle());
        return "beverage";
    }


//    @PostMapping
//    public String addBottles(@Valid Bottle bottle, Error error, Model model){
//
//        bottle.setId( this.bottleList.size() + 1);
//        this.bottleList.add(bottle);
//
//        return "beverage";
//    }

}
