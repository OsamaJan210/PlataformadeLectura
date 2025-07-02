package com.fundacioesplai.lectura.dto;

import lombok.Data;

@Data
public class LoginResponse<T> {
    private String message;
    private String token;
    private T data;
}
