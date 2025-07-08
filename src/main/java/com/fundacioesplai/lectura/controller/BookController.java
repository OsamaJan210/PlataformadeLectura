package com.fundacioesplai.lectura.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fundacioesplai.lectura.model.Book;
import com.fundacioesplai.lectura.model.BooksStatus;
import com.fundacioesplai.lectura.service.BookService;
import com.fundacioesplai.lectura.utils.ApiResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("lectura/api-v1/books")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BookController {
    private final BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createBook(@RequestBody Book req) {
        ApiResponse res = new ApiResponse<>();
        Book book = bookService.createBook(req);
        if (book != null && book.getId() != null) {
            res.setMessage("Book added successfully");
            res.setData(book);
            return ResponseEntity.ok(res);
        } else {
            res.setMessage("Failed to add book");
            return ResponseEntity.status(400).body(res);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponse> updateBook(@RequestBody Book req) {
        ApiResponse res = new ApiResponse<>();
        Book book = bookService.createBook(req); // Asumo que createBook hace upsert
        if (book != null && book.getId() != null) {
            res.setMessage("Book updated successfully");
            res.setData(book);
            return ResponseEntity.ok(res);
        } else {
            res.setMessage("Failed to update book");
            return ResponseEntity.status(400).body(res);
        }
    }

  @GetMapping("/search")
public ResponseEntity<List<Book>> searchBooks(
        @RequestParam(required = false) Integer genreId,
        @RequestParam(required = false) Integer formatId) {
    List<Book> books = bookService.search(null, genreId, null, formatId);
    return ResponseEntity.ok(books);
}



    @GetMapping("/getBooks")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = bookService.getBooks();
        return ResponseEntity.ok(books);
    }

    @PostMapping("/addStatusByUser")
    public ResponseEntity<ApiResponse> addStatusByUser(@RequestBody BooksStatus req) {
        ApiResponse res = new ApiResponse<>();
        List<BooksStatus> existingStatuses = bookService.statusByBookIdanduserId(req);

        if (existingStatuses != null && !existingStatuses.isEmpty()) {
            req.setId(existingStatuses.get(0).getId());
        }

        BooksStatus savedStatus = bookService.addStatusByUser(req);
        if (savedStatus != null && savedStatus.getId() != null) {
            res.setMessage("Book status updated");
            res.setData(savedStatus);
            return ResponseEntity.ok(res);
        } else {
            res.setMessage("Failed to update book status");
            return ResponseEntity.status(400).body(res);
        }
    }
}
