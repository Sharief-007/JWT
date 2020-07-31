package com.sharief.baig.webtoken.controller;

import com.sharief.baig.webtoken.model.User;
import com.sharief.baig.webtoken.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class SimpleController {
    UserRepository userRepository;

    @GetMapping("/")
    public List<User> home(){
        return userRepository.findAll();
    }
}
