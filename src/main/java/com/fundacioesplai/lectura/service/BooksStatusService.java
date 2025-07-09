package com.fundacioesplai.lectura.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundacioesplai.lectura.model.BooksStatus;
import com.fundacioesplai.lectura.repository.BooksStatusRepository;

@Service
public class BooksStatusService {

    @Autowired
    private BooksStatusRepository booksStatusRepository;

    public BooksStatus saveOrUpdate(BooksStatus booksStatus) {
        Optional<BooksStatus> existing = booksStatusRepository
            .findByUserIdAndBookId(booksStatus.getUser().getId(), booksStatus.getBook().getId());

        if (existing.isPresent()) {
            BooksStatus existingStatus = existing.get();
            existingStatus.setStatus(booksStatus.getStatus());
            existingStatus.setComments(booksStatus.getComments());
            existingStatus.setRating(booksStatus.getRating());
            existingStatus.setEndDate(booksStatus.getEndDate());
            return booksStatusRepository.save(existingStatus);
        } else {
            return booksStatusRepository.save(booksStatus);
        }
    }
}
