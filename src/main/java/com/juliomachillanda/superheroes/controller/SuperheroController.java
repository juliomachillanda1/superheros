package com.juliomachillanda.superheroes.controller;

import com.juliomachillanda.superheroes.domain.SuperHero;
import com.juliomachillanda.superheroes.service.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/superheros")
public class SuperHeroesController {

    @Autowired
    private SuperHeroService superHeroService;

    @GetMapping
    public List<SuperHero> findAll() {
        return superHeroService.findAll();
    }

    @PostMapping
    public SuperHero create(@RequestBody SuperHero superHero) {
        return superHeroService.create(superHero);
    }

    @PutMapping
    public SuperHero update(@RequestBody SuperHero superHero) {
        return superHeroService.update(superHero);
    }

    @GetMapping("/{id}")
    public SuperHero findById(@PathVariable("id") Long id) {
        return superHeroService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable("id") Long id) {
        superHeroService.delete(id);
    }

    @GetMapping("/service/{ch}")
    public List<String> getBy(@PathVariable("ch") String ch) {
        return superHeroService.getBy(ch);
    }

}
