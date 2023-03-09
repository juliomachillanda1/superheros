package com.juliomachillanda.superheroes.controller;

import com.juliomachillanda.superheroes.domain.Superhero;
import com.juliomachillanda.superheroes.dto.SuperheroDTO;
import com.juliomachillanda.superheroes.service.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/superheroes")
public class SuperheroController {

    @Autowired
    private SuperheroService superheroService;

    @GetMapping
    public ResponseEntity<List<SuperheroDTO>> findAll() {
        return ResponseEntity.ok(superheroService.findAll());
    }

    @PostMapping
    public ResponseEntity<SuperheroDTO> create(@RequestBody Superhero superhero) {
        return ResponseEntity.status(HttpStatus.CREATED).body(superheroService.create(superhero));
    }

    @PutMapping
    public ResponseEntity<SuperheroDTO> update(@RequestBody Superhero superhero) {
        return ResponseEntity.ok(superheroService.update(superhero));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuperheroDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(superheroService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        superheroService.deleteById(id);
    }

    @GetMapping("/search")
    public ResponseEntity<List<SuperheroDTO>> getByNameContaining(@RequestParam("name") String name) {
        return ResponseEntity.ok(superheroService.findByNameContaining(name));
    }

}
