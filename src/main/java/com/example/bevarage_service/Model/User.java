package com.example.bevarage_service.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@ToString
@Table(name = "Users", schema = "public")
public class User implements UserDetails{
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
    @ManyToMany
    @JoinTable(name = "user_address",
            joinColumns=@JoinColumn(name="user_id",nullable = false),
           inverseJoinColumns = @JoinColumn(name="address_id"))
   private Set<Address> addresses = new HashSet<Address>();

    private boolean active;
    private String roles;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(this.roles));
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public String getPassword(){
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}