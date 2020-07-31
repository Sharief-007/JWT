package com.sharief.baig.webtoken.service;

import com.sharief.baig.webtoken.dto.LoginRequest;
import com.sharief.baig.webtoken.dto.RegisterRequest;
import com.sharief.baig.webtoken.jwt.JwtUtil;
import com.sharief.baig.webtoken.model.User;
import com.sharief.baig.webtoken.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    AuthenticationManager authenticationManager;
    JwtUtil jwtUtil;

    public User register(RegisterRequest request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        return userRepository.save(user);
    }

    public String login(LoginRequest request) {
        Authentication auth = new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword());
        authenticationManager.authenticate(auth);
        return jwtUtil.GenerateJWt(request);
    }
}
