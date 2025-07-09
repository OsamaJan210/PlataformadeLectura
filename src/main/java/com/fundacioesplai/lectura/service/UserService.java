package com.fundacioesplai.lectura.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.fundacioesplai.lectura.dto.LoginReq;
import com.fundacioesplai.lectura.model.User;
import com.fundacioesplai.lectura.utils.ApiResponse;

public interface UserService {
    public User createUser(User req);
    public boolean userExsistByEmail(String email);
    public User loginUser(LoginReq req);
    public List<User> getallUser();
    public User getUserById(Integer id );

}
