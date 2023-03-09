package com.juliomachillanda.superheroes.service;

import com.juliomachillanda.superheroes.builder.SuperheroBuilder;
import com.juliomachillanda.superheroes.domain.Superhero;
import com.juliomachillanda.superheroes.dto.SuperheroDTO;
import com.juliomachillanda.superheroes.repository.SuperheroRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class SuperheroServiceTests {

    @Autowired
    private SuperheroService superheroService;

    @MockBean
    private SuperheroRepository superheroRepository;

    @Test
    public void testCreateOk() {
        Superhero superhero = SuperheroBuilder.getIronMan();
        when(superheroRepository.save(superhero)).thenReturn(superhero);

        SuperheroDTO createdSuperhero = superheroService.create(superhero);

        assertNotNull(createdSuperhero);
        assertEquals("Iron Man", createdSuperhero.getName());
        assertEquals("Suit of armor", createdSuperhero.getSuperpower());
        verify(superheroRepository, times(1)).save(superhero);
    }

    @Test
    public void testUpdateOk() {
        Superhero superhero = SuperheroBuilder.getIronMan();
        when(superheroRepository.save(superhero)).thenReturn(superhero);

        SuperheroDTO updatedSuperhero = superheroService.update(superhero);

        assertNotNull(updatedSuperhero);
        assertEquals("Iron Man", updatedSuperhero.getName());
        assertEquals("Suit of armor", updatedSuperhero.getSuperpower());
        verify(superheroRepository, times(1)).save(superhero);
    }

    @Test
    public void testFindByIdOk() {
        Superhero superhero = SuperheroBuilder.getIronMan();
        superhero.setId(1L);
        when(superheroRepository.findById(1L)).thenReturn(Optional.of(superhero));

        SuperheroDTO foundSuperhero = superheroService.findById(1L);

        assertNotNull(foundSuperhero);
        assertEquals(1, foundSuperhero.getId());
        assertEquals("Iron Man", foundSuperhero.getName());
        assertEquals("Suit of armor", foundSuperhero.getSuperpower());
        verify(superheroRepository, times(1)).findById(1L);
    }

    @Test
    public void testFindByIdWhenSuperheroIsNotFound() {
        when(superheroRepository.findById(1L)).thenReturn(Optional.empty());

        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            superheroService.findById(1L);
        });

        assertEquals("Superhero with id 1 not found", exception.getMessage());
        verify(superheroRepository, times(1)).findById(1L);
    }

    @Test
    public void testFindAllOk() {
        Superhero ironMan = SuperheroBuilder.getIronMan();
        Superhero wonderWoman = SuperheroBuilder.getWonderWoman();
        when(superheroRepository.findAll()).thenReturn(List.of(ironMan, wonderWoman));

        List<SuperheroDTO> superheroes = superheroService.findAll();

        assertEquals(2, superheroes.size());
        assertEquals("Iron Man", superheroes.get(0).getName());
        assertEquals("Wonder Woman", superheroes.get(1).getName());
        verify(superheroRepository, times(1)).findAll();
    }

    @Test
    public void testDeleteOk() {
        doNothing().when(superheroRepository).deleteById(1L);

        superheroService.deleteById(1L);

        verify(superheroRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testGetByNameContaining() {
        Superhero ironMan = SuperheroBuilder.getIronMan();
        Superhero wonderWoman = SuperheroBuilder.getWonderWoman();
        when(superheroRepository.findByNameContaining("Man")).thenReturn(List.of(ironMan, wonderWoman));

        List<SuperheroDTO> superheroes = superheroService.findByNameContaining("Man");

        assertEquals(2, superheroes.size());
        assertEquals("Iron Man", superheroes.get(0).getName());
        assertEquals("Wonder Woman", superheroes.get(1).getName());
        verify(superheroRepository, times(1)).findByNameContaining("Man");
    }

}
