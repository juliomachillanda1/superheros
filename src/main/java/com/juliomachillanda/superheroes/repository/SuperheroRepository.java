package com.juliomachillanda.superheroes.repository;

import com.juliomachillanda.superheroes.domain.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuperheroRepository extends JpaRepository<Superhero, Long> {

    List<Superhero> findByNameContaining(String name);
}
