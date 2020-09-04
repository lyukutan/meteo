package com.example.country.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "ident", unique = true, nullable = false)
    private String ident;

    @Column(name = "fio", unique = true, nullable = false)
    private String fio;

    @Column(name = "country")
    private String country;
    
}
