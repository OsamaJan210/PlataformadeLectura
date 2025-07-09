package com.fundacioesplai.lectura.service.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fundacioesplai.lectura.dto.LoginReq;
import com.fundacioesplai.lectura.model.User;
import com.fundacioesplai.lectura.repository.UserRepo;
import com.fundacioesplai.lectura.service.UserService;
import com.fundacioesplai.lectura.utils.SecurityUtils;

import lombok.AllArgsConstructor;

@Service("UserService")
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Override
    public boolean userExsistByEmail(String email) {
        return userRepo.existsByEmail(email);
    }

    @Override
    public User createUser(User req) {
        try {

            req.setPassword(SecurityUtils.encryptMD5(req.getPassword()));
            User user = userRepo.save(req);
            return user;

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());

        }

    }
    @Override
    public User loginUser(LoginReq req) {
        try {
            User user = userRepo.findByEmailAndPassword(req.getEmail(), SecurityUtils.encryptMD5(req.getPassword()));
            return user;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override 
    public List<User> getallUser(){
       return userRepo.findAll();
    }
    @Override
    public User getUserById(Integer id ){
        return userRepo.findById(id).get();
    }


    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> findByUsernameNot(String username) {
        return userRepo.findByUsernameNot(username);
    }
}
