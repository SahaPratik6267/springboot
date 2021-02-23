//package com.example.bevarage_service.Service;
//
//import com.example.bevarage_service.Model.User;
//import com.example.bevarage_service.repository.UserRepository;
//
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.BDDMockito;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import static org.mockito.BDDMockito.given;
//import java.time.LocalDate;
//import java.util.Optional;
//
//import org.junit.Test;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.BDDMockito.given;
//import static org.junit.Assert.*;
//import static org.junit.matchers.JUnitMatchers.*;
//
//@ExtendWith(MockitoExtension.class)
//class UserServiceTest {
//    @Mock
//    private UserRepository userRepository;
//
//    @InjectMocks
//    private UserService userService;
//
//    @Test
//    void findUserByUserName(){
//        final String username="DanTheMan";
//        final User user=new User(null,"DanTheMan", "Man123", LocalDate.of(1991, 10, 12) ,null,null,true,"ADMIN");
//        given(userRepository.findUserByUserName(username)).willReturn(Optional.of(user));
//
//        final Optional<User> expected= userService.loadUserByUsername(username);
//
//        assertThat(expected).isNotNull();
//
//    }
//}