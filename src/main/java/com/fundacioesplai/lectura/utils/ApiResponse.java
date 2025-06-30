package com.fundacioesplai.lectura.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

    private String code;
    private Boolean status;
    private String message;
    private T data;

}