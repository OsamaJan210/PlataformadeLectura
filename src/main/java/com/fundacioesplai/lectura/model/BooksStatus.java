package com.fundacioesplai.lectura.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "books_status")

@Data
public class BooksStatus extends BaseWithDateDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @Column( length = 255)
    private String comments;

    @Column
    private Integer rating;


    @Column(name = "end_date")
    private LocalDateTime endDate;
    
}
