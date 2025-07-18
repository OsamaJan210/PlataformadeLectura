package com.fundacioesplai.lectura.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundacioesplai.lectura.dto.LoginReq;
import com.fundacioesplai.lectura.dto.LoginResponse;
import com.fundacioesplai.lectura.model.User;
import com.fundacioesplai.lectura.service.UserService;
import com.fundacioesplai.lectura.utils.JwtUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class LoginController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody LoginReq req) {
        LoginResponse resp = new LoginResponse<>();
        User user = userService.loginUser(req);
        if (user != null) {
            resp.setMessage("Login Suscessfully");
            String token = jwtUtil.generateToken(user.getUsername());
            resp.setToken(token);

            return resp;
        } else {
            resp.setMessage("Login Failed");
            return resp;
        }
    }

    @GetMapping("/me")
    public ResponseEntity<?> getUserInfo(Authentication authentication) {
        try {
            String username = authentication.getName();
            User user = userService.findByUsername(username);
            if (user == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving user info");
        }
    }

    @GetMapping("/users")
    public ResponseEntity<?> getOtherUsers(Authentication authentication) {
        try {
            String username = authentication.getName();
            // Traer todos los usuarios excepto el que tiene este username
            List<User> otherUsers = userService.findByUsernameNot(username);
            return ResponseEntity.ok(otherUsers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving users");
        }
    }

}
