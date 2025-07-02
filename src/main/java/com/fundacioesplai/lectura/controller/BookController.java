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
import com.fundacioesplai.lectura.model.User;
import com.fundacioesplai.lectura.service.BookService;
import com.fundacioesplai.lectura.service.UserService;
import com.fundacioesplai.lectura.utils.ApiResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("lectura/api-v1/books")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BookController {
    private final BookService bookService;

    @PostMapping("/create")
    public ApiResponse createBook(@RequestBody Book req) {
        ApiResponse res = new ApiResponse<>();
        Book book = bookService.createBook(req);
        if (book.getId() != null) {
            res.setMessage("Book Added Successfully");
            res.setData(book);
        }
        else {
            res.setMessage("Book Added failed");
        }
        return res;

    }

    @PostMapping("/update")
    public ApiResponse UpdateBook(@RequestBody Book req) {
        ApiResponse res = new ApiResponse<>();
        Book book = bookService.createBook(req);

        if (book.getId() != null) {
                res.setMessage("Book update Successfully");
                res.setData(book);

        }
        else {
            res.setMessage("Book update failed");
        }

        return res;

    }

    @GetMapping("/search")
    public List<Book> searchBooks(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Integer genreId,
            @RequestParam(required = false) Integer statusId,
            @RequestParam(required = false) Integer formatId) {
        return bookService.search(keyword, genreId, statusId, formatId);
    }
    @PostMapping("/addStatusByUser")
    public ApiResponse addStatusByUser(@RequestBody BooksStatus req) {
        ApiResponse res = new ApiResponse<>();

        List<BooksStatus> booksStatus=bookService.statusByBookIdanduserId(req);
        if(booksStatus.size()>0){
            req.setId(booksStatus.get(0).getId());
        }
        BooksStatus book = bookService.addStatusByUser(req);

        if (book.getId() != null) {
                res.setMessage("Book Status updated");
                res.setData(book);

        }
        else {
            res.setMessage("Book Status update failed");
        }

        return res;

    }
}
