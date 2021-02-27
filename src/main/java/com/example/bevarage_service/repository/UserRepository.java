package com.example.bevarage_service.repository;

import com.example.bevarage_service.Model.Users;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
   // @Query(value = "SELECT TOP '1' * FROM USER ORDER BY ID DESC", nativeQuery = true)


    @EntityGraph(value = "User.Orders")
    public Users findUserByid(Long ID);


   @EntityGraph(value = "user.user")
    public Users findUserByUserName(String userName);

}
