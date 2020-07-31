package com.sharief.baig.webtoken.controller;

import com.sharief.baig.webtoken.dto.LoginRequest;
import com.sharief.baig.webtoken.dto.RegisterRequest;
import com.sharief.baig.webtoken.model.User;
import com.sharief.baig.webtoken.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class BasicController {
    AuthService authService;

    @PostMapping("/auth/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User register(@RequestBody RegisterRequest request){
        return authService.register(request);
    }

    @PostMapping("/auth/login")
    public String login(@RequestBody LoginRequest request){
        return authService.login(request);
    }
}
