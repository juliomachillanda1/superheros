package com.juliomachillanda.superheroes.service;

import com.juliomachillanda.superheroes.domain.Superhero;
import com.juliomachillanda.superheroes.dto.SuperheroDTO;

import java.util.List;

public interface SuperheroService {

    SuperheroDTO create(Superhero superHero);

    SuperheroDTO update(Superhero superHero);

    SuperheroDTO findById(Long id);

    List<SuperheroDTO> findAll();

    void deleteById(Long id);

    List<SuperheroDTO> findByNameContaining(String name);

}
