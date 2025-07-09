package com.fundacioesplai.lectura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundacioesplai.lectura.dto.BooksStatusDTO;
import com.fundacioesplai.lectura.model.BooksStatus;
import com.fundacioesplai.lectura.service.serviceimpl.BooksStatusService;

@RestController
@RequestMapping("/api/books-status")
public class BooksStatusController {

    @Autowired
    private BooksStatusService booksStatusService;

    @PostMapping("/set-status")
    public ResponseEntity<?> setBookStatus(@RequestBody BooksStatusDTO dto) {
        try {
            BooksStatus saved = booksStatusService.setBookStatus(
                dto.getUserId(),
                dto.getBookId(),
                dto.getStatusId(),
                dto.getComments(),
                dto.getRating()
            );
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error guardando el estado del libro: " + e.getMessage());
        }
    }
}
