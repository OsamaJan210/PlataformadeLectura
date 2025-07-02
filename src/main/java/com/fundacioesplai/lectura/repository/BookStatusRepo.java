package com.fundacioesplai.lectura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundacioesplai.lectura.model.BooksStatus;

public interface BookStatusRepo extends JpaRepository<BooksStatus,Integer> {
    List<BooksStatus> findByUserIdAndBookId(Integer userId, Integer bookId);
    
}
