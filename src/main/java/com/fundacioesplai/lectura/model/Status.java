package com.fundacioesplai.lectura.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "book_status")
@Data
public class Status {

    @Id
    private Integer id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(length = 255)
    private String description;

}
