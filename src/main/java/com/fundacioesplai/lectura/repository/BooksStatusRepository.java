package com.fundacioesplai.lectura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundacioesplai.lectura.model.BooksStatus;

public interface BooksStatusRepository extends JpaRepository<BooksStatus, Integer> {
    List<BooksStatus> findByUser_IdAndBook_Id(Integer userId, Integer bookId);
}


