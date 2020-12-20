package com.example.bevarage_service.Demo;

import com.example.bevarage_service.Model.*;
import com.example.bevarage_service.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
@Component
public class DemoData {

    private final BottleRepository bottleRepo;
    private final CrateRepository crateRepo;
    private final OrdersRepository ordersRepo;
    private final OrderItemRepository orderItemRepo;
    private final UserRepository userRepos;
    private final AddressRepository addressRepo;


    @Autowired
    public DemoData(BottleRepository bottleRepo, CrateRepository crateRepo, OrdersRepository ordersRepo, OrderItemRepository orderItemRepo, UserRepository userRepos, AddressRepository addressRepo) {
        this.bottleRepo = bottleRepo;
        this.crateRepo = crateRepo;
        this.ordersRepo = ordersRepo;
        this.orderItemRepo = orderItemRepo;
        this.userRepos = userRepos;
        this.addressRepo = addressRepo;
    }

    /**
     * We create some demo data here, when the database schema is created and the app is ready.
     *
     * @param event
     */
    @EventListener
    public void createDemoData(ApplicationReadyEvent event) {

        // not storing the crates, users and orders directly. They are stored transitively (CASCADE.MERGE) when the bottles and orderItems are stored.

        Crate SoftDrink = new Crate(1L, "DrinkCrate", "https://cdn.pixabay.com/photo/2015/07/13/18/46/pepsi-843648_960_720.jpg", 6, 10, 1, null);
        Crate Beer = new Crate(2L, "BeerCrate", "https://cdn.pixabay.com/photo/2014/08/10/18/06/beer-414914_960_720.jpg", 6, 15, 2, null);

        Address firstAddress = new Address(1L, "Baker Street", "22A", "96047", null);
        Address secondAddress = new Address(2L, "Pasadena", "4C", "96052", null);

        // Saving two addresses
        this.addressRepo.saveAll(Arrays.asList(firstAddress, secondAddress));

        User Dan = new User(1L, "DanTheMan", "Man123", LocalDate.of(1991, 10, 12), null, new ArrayList<>(Arrays.asList(secondAddress, firstAddress)));
        User Jessica = new User(2L, "JessicaChobot", "Woman123", LocalDate.of(1994, 11, 23), null, new ArrayList<>(Arrays.asList(firstAddress)));

        Orders BottleOrder = new Orders(1L, 48, null, Dan);
        Orders CrateOrder = new Orders(2L, 15, null, Jessica);


        Bottle Pepsi = new Bottle(1L, "Pepsi", "https://cdn.pixabay.com/photo/2014/08/10/18/06/beer-414914_960_720.jpg", 5.5, false, 0.0, 12, "Pepsi Inc.", 10, SoftDrink, null);
        Bottle Cola = new Bottle(2L, "Cola", "https://cdn.pixabay.com/photo/2014/09/26/19/51/drink-462776_960_720.jpg", 7.5, false, 0.0, 10, "Coca-Cola Inc.", 15, null, null);
        Bottle Corona = new Bottle(3L, "Corona", "https://cdn.pixabay.com/photo/2015/01/16/15/01/bottle-601566_960_720.jpg", 10.5, true, 8.5, 15, "Corona Inc.", 20, Beer, null);

        OrderItem bottleItem = new OrderItem(1L, "1", 12, 4, BottleOrder, Pepsi);
        OrderItem crateItem = new OrderItem(2L, "2", 15, 1, CrateOrder, Corona);


        // saving bottles & orderItems
        this.bottleRepo.saveAll(Arrays.asList(Pepsi, Cola, Corona));
        this.orderItemRepo.saveAll(Arrays.asList(bottleItem, crateItem));


    }
}
