package com.fundacioesplai.lectura.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fundacioesplai.lectura.model.BooksStatus;

public interface BooksStatusRepo extends JpaRepository<BooksStatus, Integer> {
    Optional<BooksStatus> findByUserIdAndBookId(Integer userId, Integer bookId);
}
