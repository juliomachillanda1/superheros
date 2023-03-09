package com.juliomachillanda.superheroes.service.impl;

import com.juliomachillanda.superheroes.domain.Superhero;
import com.juliomachillanda.superheroes.dto.SuperheroDTO;
import com.juliomachillanda.superheroes.mapper.SuperheroMapper;
import com.juliomachillanda.superheroes.repository.SuperheroRepository;
import com.juliomachillanda.superheroes.service.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SuperheroServiceImpl implements SuperheroService {

    @Autowired
    private SuperheroRepository superheroRepository;

    @Autowired
    private SuperheroMapper superheroMapper;

    @Override
    public SuperheroDTO create(Superhero superHero) {
        Superhero superhero = superheroRepository.save(superHero);
        return superheroMapper.entityToDto(superhero);
    }

    @Override
    public SuperheroDTO update(Superhero superHero) {
        Superhero superhero = superheroRepository.save(superHero);
        return superheroMapper.entityToDto(superhero);
    }

    @Override
    public SuperheroDTO findById(Long id) {
        Superhero superhero = superheroRepository.findById(id)
                .orElseThrow(
                        () -> new NoSuchElementException(String.format("Superhero with id %d not found", id))
                );

        return superheroMapper.entityToDto(superhero);
    }

    @Override
    public List<SuperheroDTO> findAll() {
        List<Superhero> superheroes = superheroRepository.findAll();
        return superheroMapper.entitiesToDtos(superheroes);
    }

    @Override
    public void deleteById(Long id) {
        superheroRepository.deleteById(id);
    }

    public List<SuperheroDTO> findByNameContaining(String name) {
        List<Superhero> superheroes = superheroRepository.findByNameContaining(name);
        return superheroMapper.entitiesToDtos(superheroes);
    }

}
