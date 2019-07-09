package com.ticketsh.ticketshow.services;

import com.ticketsh.ticketshow.entities.User;
import com.ticketsh.ticketshow.repositories.UserRepository;
import com.ticketsh.ticketshow.services.impl.UserServiceImpl;
import static org.mockito.BDDMockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;


    public void testLoadUserByUsername() {

        User user=new User();
//
//        user.setRolList(Arrays.asList(new ));
//
//        given(userRepository.findByUsername("ADMIN")).willReturn(null);


    }

}