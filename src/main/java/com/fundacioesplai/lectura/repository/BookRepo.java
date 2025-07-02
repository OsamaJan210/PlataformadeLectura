package com.fundacioesplai.lectura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundacioesplai.lectura.model.Book;

public interface  BookRepo extends JpaRepository<Book,Integer> {
    
}
