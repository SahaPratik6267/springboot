package com.example.bevarage_service.Service;

import com.example.bevarage_service.Model.User;
import com.example.bevarage_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){this.userRepository=userRepository;}
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRepository.findUserByUserName(username);
        if(user!=null){
            System.out.println("here comes second");
    return user;}
        else throw new UsernameNotFoundException("username not found in db");
    }

}
