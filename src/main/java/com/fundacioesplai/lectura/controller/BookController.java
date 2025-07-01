package com.fundacioesplai.lectura.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundacioesplai.lectura.model.Book;
import com.fundacioesplai.lectura.model.User;
import com.fundacioesplai.lectura.service.BookService;
import com.fundacioesplai.lectura.service.UserService;
import com.fundacioesplai.lectura.utils.ResponseEntityResult;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("lectura/api-v1/books")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BookController {
    private final ResponseEntityResult responseEntityResult;
    private final BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<?> createBook(@RequestBody Book req){
        return responseEntityResult.responseEntity(bookService.createBook(req));

    }
    @PostMapping("/update")
    public ResponseEntity<?> UpdateBook(@RequestBody Book req){
        return responseEntityResult.responseEntity(bookService.createBook(req));

    }
}
