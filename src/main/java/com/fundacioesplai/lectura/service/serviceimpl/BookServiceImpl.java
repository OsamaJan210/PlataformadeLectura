package com.fundacioesplai.lectura.service.serviceimpl;

import org.springframework.stereotype.Service;

import com.fundacioesplai.lectura.model.Book;
import com.fundacioesplai.lectura.repository.BookRepo;
import com.fundacioesplai.lectura.service.BookService;
import com.fundacioesplai.lectura.utils.ApiResponse;

import lombok.AllArgsConstructor;

@Service("BookService")
@AllArgsConstructor
public class BookServiceImpl implements BookService {


    private final BookRepo bookRepo;

    @Override 
    public ApiResponse createBook(Book req){
        ApiResponse response =new ApiResponse<>();

        try{
            bookRepo.save(req);


            response.setCode("200");
            response.setMessage("Book Added");
            response.setStatus(true);
            return response;
        }
        catch(Exception ex){
            response.setCode("500");
            response.setStatus(false);
            response.setMessage(ex.getMessage());
            return response;
        }
    }
    
}
