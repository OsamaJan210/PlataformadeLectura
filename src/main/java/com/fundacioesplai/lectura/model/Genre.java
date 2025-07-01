package com.fundacioesplai.lectura.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "book_genre")
@Data
public class Genre {

    @Id
    private Integer id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(length = 255)
    private String description;

}
