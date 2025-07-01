package com.fundacioesplai.lectura.service;

import com.fundacioesplai.lectura.model.Book;
import com.fundacioesplai.lectura.model.User;
import com.fundacioesplai.lectura.utils.ApiResponse;

public interface BookService {
    public ApiResponse createBook(Book req);
}