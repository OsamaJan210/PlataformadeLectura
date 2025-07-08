package com.fundacioesplai.lectura.service;

import java.util.List;

import com.fundacioesplai.lectura.model.Book;
import com.fundacioesplai.lectura.model.BooksStatus;

public interface BookService {
    
    Book createBook(Book req);
    
    List<Book> search(String keyword, Integer genreId, Integer statusId, Integer formatId);
    
    List<Book> getBooks();
    
    BooksStatus addStatusByUser(BooksStatus req);
    
    List<BooksStatus> statusByBookIdanduserId(BooksStatus req);
    
}
