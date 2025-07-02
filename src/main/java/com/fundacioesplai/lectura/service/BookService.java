package com.fundacioesplai.lectura.service;

import java.util.List;

import com.fundacioesplai.lectura.model.Book;
import com.fundacioesplai.lectura.model.BooksStatus;
import com.fundacioesplai.lectura.model.User;
import com.fundacioesplai.lectura.utils.ApiResponse;

public interface BookService {
    public Book createBook(Book req);
    public List<Book> search(String keyword, Integer genreId, Integer statusId, Integer formatId);
    public BooksStatus addStatusByUser(BooksStatus req);
    public List<BooksStatus> statusByBookIdanduserId(BooksStatus req);

}