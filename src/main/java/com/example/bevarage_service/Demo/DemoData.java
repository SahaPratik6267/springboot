package com.example.bevarage_service.Demo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


import com.example.bevarage_service.Model.*;
import com.example.bevarage_service.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


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

        log.info("demo data started");



        Users Dan = new Users(1L, "DanTheMan", new BCryptPasswordEncoder().encode("man123"), LocalDate.of(1991, 10, 12),null,true,"ROLE_USER");
        log.info("dan");
        Users test= new Users(2L,"test", new BCryptPasswordEncoder().encode("test"),LocalDate.of(1991, 10, 12),null,true,"ROLE_ADMIN");
        log.info("test");

        this.userRepos.saveAll(Arrays.asList(Dan,test));


//        Set<Users> users = new HashSet();
//        users.add(Dan);
//        users.add(test);

        log.info("save");

        Address firstAddress = new Address(1L, "Baker Street", "22A", "96047");
        log.info("add1");
        Address secondAddress = new Address(2L, "Pasadena", "4C", "96052");
        this.addressRepo.saveAll(Arrays.asList(firstAddress, secondAddress));

//        Set<Address> address= new HashSet<>();
//        address.add(firstAddress);
//        address.add(secondAddress);
//
//        Dan.setAddresses(address);
//        test.setAddresses(address);


//        this.userRepos.saveAll(Arrays.asList(Dan,test));





        Bottle Pepsi = new Bottle("Pepsi", "https://cdn.pixabay.com/photo/2014/08/10/18/06/beer-414914_960_720.jpg", 5.5, 0.0, 12, "Pepsi Inc.", 10);
        Bottle Cola = new Bottle("Cola", "https://cdn.pixabay.com/photo/2014/09/26/19/51/drink-462776_960_720.jpg", 7.5, 0.0, 10, "Coca-Cola Inc.", 15);
        Bottle Corona = new Bottle("Corona", "https://cdn.pixabay.com/photo/2015/01/16/15/01/bottle-601566_960_720.jpg", 10.5, 8.5, 15, "Corona Inc.", 20);

        // not storing the crates, users and orders directly. They are stored transitively (CASCADE.MERGE) when the bottles and orderItems are stored.

        Crate PepsiCrate = new Crate("PepsiCrate", "https://cdn.pixabay.com/photo/2015/07/13/18/46/pepsi-843648_960_720.jpg", 6, 10, 1, Pepsi);
        Crate BeerCrate = new Crate("CoronaCrate", "https://cdn.pixabay.com/photo/2014/08/10/18/06/beer-414914_960_720.jpg", 6, 15, 2, Corona);



        // Saving two addresses


        Orders BottleOrder =
                new Orders(1L, 48,null,  Dan);
        Orders CrateOrder = new Orders(2L, 15,null, test);


        OrderItem bottleItem = new OrderItem(1L, "1", 12, 4, BottleOrder, Pepsi);
        OrderItem crateItem = new OrderItem(2L, "2", 15, 1, CrateOrder, BeerCrate);


        // saving bottles & orderItems
        this.bottleRepo.saveAll(Arrays.asList(Pepsi, Cola, Corona));
        this.crateRepo.saveAll(Arrays.asList(PepsiCrate, BeerCrate));
        this.orderItemRepo.saveAll(Arrays.asList(bottleItem, crateItem));


        log.info("demo data ended");


    }
}
