package com.example.bevarage_service.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
//@NamedEntityGraph(name = "Address.users",
//attributeNodes = @NamedAttributeNode("users"))
public class Address {
    @Id
    private Long id;
    @NotNull(message = "Street Name must be set")
    @NotEmpty(message = "Street Name not there")
    private String street;
    @NotNull(message = "Street number must be set")
    @NotEmpty(message = "Street number not there")
    private String number;
    @NotNull(message = "Postal code must be set")
    @NotEmpty(message = "Postal code not there")
    @Pattern(regexp = "\\b\\d{5}\\b")
    private String postalCode;
   @ManyToMany (mappedBy = "addresses", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
   private Set<User> users= new HashSet<User>();

}
