package com.fundacioesplai.lectura.service;

import com.fundacioesplai.lectura.dto.UserReq;
import com.fundacioesplai.lectura.model.User;
import com.fundacioesplai.lectura.utils.ApiResponse;

public interface UserService {
    public ApiResponse createUser(User req);
    public ApiResponse loginUser(User req);
}
