package com.example.bevarage_service.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@ToString
//@NamedEntityGraph(name = "User.orders", attributeNodes = @NamedAttributeNode(value = "orders"))
@Table(name = "Users", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @NotNull(message = "Name must be set")
    @NotEmpty(message = "Name not there")
    private String userName;
    @NotNull(message = "password must be set")
    @NotEmpty(message = "password not there")
    private String password;
    @Past(message = "Birth date must be in the past")
    private LocalDate birthday;

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<Orders> orders;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_address",
            joinColumns=@JoinColumn(name="user_id",nullable = false),
           inverseJoinColumns = @JoinColumn(name="address_id"))
   private Set<Address> addresses;

    private boolean active;
    private String roles;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
}