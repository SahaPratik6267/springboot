package com.example.bevarage_service.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@NamedEntityGraph(name = "User.users",
//attributeNodes = @NamedAttributeNode(value = "addresses"))
public class User {
    @Id
    private Long id;
    @NotNull(message = "Name must be set")
    @NotEmpty(message = "Name not there")
    private String username;
    @NotNull(message = "password must be set")
    @NotEmpty(message = "password not there")
    private String password;
    @Past(message = "Birth date must be in the past")
    private LocalDate birthday;
   // @ManyToMany(fetch = FetchType.LAZY)
   // @JoinTable(name = "user_address",
   //         joinColumns=@JoinColumn(name="user_id"),
   //         inverseJoinColumns = @JoinColumn(name="address_id"))
  // private List<Address> addresses;
}