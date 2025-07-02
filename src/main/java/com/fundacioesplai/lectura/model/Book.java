package com.fundacioesplai.lectura.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "books")

@Data
public class Book extends BaseWithDateDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, length = 255)
    private String author;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    
    

    @ManyToOne
    @JoinColumn(name = "format_id")
    private Format format;

    

    @Column(name = "end_date")
    private LocalDateTime endDate;
    
}
