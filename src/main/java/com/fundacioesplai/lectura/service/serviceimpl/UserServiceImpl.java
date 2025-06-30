package com.fundacioesplai.lectura.service.serviceimpl;

import com.fundacioesplai.lectura.dto.UserReq;
import com.fundacioesplai.lectura.model.User;
import com.fundacioesplai.lectura.repository.UserRepo;
import com.fundacioesplai.lectura.service.UserService;
import com.fundacioesplai.lectura.utils.ApiResponse;
import com.fundacioesplai.lectura.utils.SecurityUtils;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service("UserService")
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    @Override
    public ApiResponse createUser(User req){
        ApiResponse response =new ApiResponse();
        try{

            req.setPassword(SecurityUtils.encryptMD5(req.getPassword()));
            System.out.println(req.toString());
            userRepo.save(req);
            response.setCode("200");
            response.setMessage("USer Created");
            response.setStatus(true);
        }
        catch(Exception ex){
            response.setCode("500");
            response.setMessage(ex.getMessage());
        }
        


        return  response;
    }
}
