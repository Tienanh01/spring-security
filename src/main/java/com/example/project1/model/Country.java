package com.example.project1.model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "country")
public class Country {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name ;

    private String description ;


}
