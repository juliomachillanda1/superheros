package com.juliomachillanda.superheroes.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "superheroes")
@Data
public class Superhero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "superpower")
    private String superpower;
}
