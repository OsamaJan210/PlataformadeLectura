package com.fundacioesplai.lectura.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundacioesplai.lectura.model.User;
import com.fundacioesplai.lectura.service.UserService;
import com.fundacioesplai.lectura.utils.ApiResponse;
import com.fundacioesplai.lectura.utils.JwtUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("lectura/api-v1/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/create")
    public ApiResponse createUser(@RequestBody User req){
        // return responseEntityResult.responseEntity(userService.createUser(req));
        ApiResponse res = new ApiResponse<>();
        if(userService.userExsistByEmail(req.getEmail())){
            res.setMessage("User Already Exsist");
            return res;
        }

        User user= userService.createUser(req);
        if (user.getId() != null) {
            res.setMessage("User Added Successfully");
            res.setData(user);
        }
        else {
            res.setMessage("User Added failed");
        }
        return res;

    }


}
