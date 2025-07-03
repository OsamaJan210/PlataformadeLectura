package com.fundacioesplai.lectura.controller;

import com.fundacioesplai.lectura.dto.LoginResponse;
import com.fundacioesplai.lectura.dto.LoginReq;
import com.fundacioesplai.lectura.model.User;
import com.fundacioesplai.lectura.service.UserService;
import com.fundacioesplai.lectura.utils.ApiResponse;
import com.fundacioesplai.lectura.utils.JwtUtil;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class LoginController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody LoginReq req){
        LoginResponse resp=new LoginResponse<>();
        User user =userService.loginUser(req);
        if(user!=null){
            resp.setMessage("Login Suscessfully");
            String token = jwtUtil.generateToken(user.getUsername());
            resp.setToken(token);

            return resp;
        }
        else{
            resp.setMessage("Login Failed");
            return resp;
        }
    }


}
