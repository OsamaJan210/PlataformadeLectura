package com.fundacioesplai.lectura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundacioesplai.lectura.model.BooksStatus;
import com.fundacioesplai.lectura.service.BooksStatusService;

@RestController
@RequestMapping("/lectura/api-v1/booksStatus")
public class BooksStatusController {

    @Autowired
    private BooksStatusService booksStatusService;

    @PostMapping("/add")
    public ResponseEntity<?> addBookStatus(@RequestBody BooksStatus booksStatus) {
        try {
            BooksStatus savedStatus = booksStatusService.saveOrUpdate(booksStatus);
            return ResponseEntity.ok(savedStatus);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error guardando el estado del libro: " + e.getMessage());
        }
    }
}
