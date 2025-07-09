package com.fundacioesplai.lectura.service.serviceimpl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundacioesplai.lectura.model.Book;
import com.fundacioesplai.lectura.model.BooksStatus;
import com.fundacioesplai.lectura.model.Status;
import com.fundacioesplai.lectura.model.User;
import com.fundacioesplai.lectura.repository.BookRepo;
import com.fundacioesplai.lectura.repository.BooksStatusRepository;
import com.fundacioesplai.lectura.repository.StatusRepository;
import com.fundacioesplai.lectura.repository.UserRepo;

@Service
public class BooksStatusService {

    @Autowired
    private BooksStatusRepository booksStatusRepository;

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private BookRepo bookRepository;

    @Autowired
    private StatusRepository statusRepository;

    public BooksStatus setBookStatus(Integer userId, Integer bookId, Integer statusId, String comments, Integer rating) {
        // Buscar usuario
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Buscar libro
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        // Buscar estado
        Status status = statusRepository.findById(statusId)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));

        // Buscar si ya existe un BooksStatus para ese usuario y libro
        Optional<BooksStatus> existing = booksStatusRepository.findByUser_IdAndBook_Id(userId, bookId)
        .stream().findFirst();


        BooksStatus booksStatus = existing.orElse(new BooksStatus());
        booksStatus.setUser(user);
        booksStatus.setBook(book);
        booksStatus.setStatus(status);

        // Si el estado es "Leído" (por ejemplo id = 3), añadimos comentarios, rating y fecha
        if (statusId == 3) {
            booksStatus.setComments(comments);
            booksStatus.setRating(rating);
            booksStatus.setEndDate(LocalDateTime.now());
        } else {
            // Para otros estados limpiamos esos campos
            booksStatus.setComments(null);
            booksStatus.setRating(null);
            booksStatus.setEndDate(null);
        }

        // Guardar y devolver
        return booksStatusRepository.save(booksStatus);
    }
}
