package com.fundacioesplai.lectura.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Service;

import com.fundacioesplai.lectura.model.Book;
import com.fundacioesplai.lectura.model.BooksStatus;
import com.fundacioesplai.lectura.repository.BookRepo;
import com.fundacioesplai.lectura.repository.BookStatusRepo;
import com.fundacioesplai.lectura.service.BookService;
import com.fundacioesplai.lectura.utils.ApiResponse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;

@Service("BookService")
@AllArgsConstructor
public class BookServiceImpl implements BookService {


    private final BookRepo bookRepo;
    private final BookStatusRepo bookStatusRepo;
    @PersistenceContext
    private EntityManager entityManager;

    @Override 
    public Book createBook(Book req){

        Book book = new Book();
        try{
            book= bookRepo.save(req);

        }
        catch(Exception ex){
        }
        return book;
    }
    
    @Override
    public List<Book> search(String keyword, Integer genreId, Integer statusId, Integer formatId) {
        StringBuilder jpql = new StringBuilder("SELECT b FROM Book b");
        List<String> conditions = new ArrayList<>();
    
        if (keyword != null && !keyword.trim().isEmpty()) {
            conditions.add("(LOWER(b.title) LIKE :keyword OR LOWER(b.author) LIKE :keyword)");
        }
        if (genreId != null) {
            conditions.add("b.genre.id = :genreId");
        }
        if (statusId != null) {
            conditions.add("b.status.id = :statusId");
        }
        if (formatId != null) {
            conditions.add("b.format.id = :formatId");
        }
    
        if (!conditions.isEmpty()) {
            jpql.append(" WHERE ");
            jpql.append(String.join(" AND ", conditions));
        }
    
        TypedQuery<Book> query = entityManager.createQuery(jpql.toString(), Book.class);
    
        if (keyword != null && !keyword.trim().isEmpty()) {
            query.setParameter("keyword", "%" + keyword.toLowerCase() + "%");
        }
        if (genreId != null) {
            query.setParameter("genreId", genreId);
        }
        if (statusId != null) {
            query.setParameter("statusId", statusId);
        }
        if (formatId != null) {
            query.setParameter("formatId", formatId);
        }

        System.out.println("size-----------"+query.getResultList().size());
    
        return query.getResultList();
    }

    @Override 
    public BooksStatus addStatusByUser(BooksStatus req){

        BooksStatus bookStatus = new BooksStatus();
        try{
            bookStatus=bookStatusRepo.save(req);

        }
        catch(Exception ex){
        }
        return bookStatus;
    }

    @Override
    public List<BooksStatus> statusByBookIdanduserId(BooksStatus req){
        List<BooksStatus> booksStatus=bookStatusRepo.findByUserIdAndBookId(req.getUser().getId(),req.getBook().getId());
        return booksStatus;

    }
    @Override
    public List<Book> getBooks(){
        return bookRepo.findAll();
    }

    
}
