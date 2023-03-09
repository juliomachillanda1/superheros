package com.juliomachillanda.superheroes.repository;

import com.juliomachillanda.superheroes.builder.SuperheroBuilder;
import com.juliomachillanda.superheroes.domain.Superhero;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class SuperheroRepositoryTest {

    @Autowired
    private SuperheroRepository superheroRepository;

    @Test
    public void testSaveOk() {
        Superhero superhero = SuperheroBuilder.getSpiderMan();

        superheroRepository.save(superhero);

        assertNotNull(superhero.getId());
    }

    @Test
    public void testFindByIdOk() {
        Superhero superhero = SuperheroBuilder.getIronMan();
        superheroRepository.save(superhero);

        Optional<Superhero> foundSuperhero = superheroRepository.findById(superhero.getId());

        assertTrue(foundSuperhero.isPresent());
        assertEquals("Iron Man", foundSuperhero.get().getName());
        assertEquals("Suit of armor", foundSuperhero.get().getSuperpower());
    }

    @Test
    public void testFindAllOk() {
        Superhero wonderWoman = SuperheroBuilder.getWonderWoman();
        superheroRepository.save(wonderWoman);

        Superhero batman = SuperheroBuilder.getBatman();
        superheroRepository.save(batman);

        List<Superhero> superheroes = superheroRepository.findAll();

        assertEquals(2, superheroes.size());
        assertEquals("Wonder Woman", superheroes.get(0).getName());
        assertEquals("Batman", superheroes.get(1).getName());
    }

    @Test
    public void testDeleteById() {
        Superhero superhero = SuperheroBuilder.getSpiderMan();
        superheroRepository.save(superhero);

        superheroRepository.deleteById(superhero.getId());

        Optional<Superhero> superheroOptional = superheroRepository.findById(superhero.getId());
        assertTrue(superheroOptional.isEmpty());
    }

    @Test
    public void testGetByNameContaining() {
        Superhero spiderMan = SuperheroBuilder.getSpiderMan();
        Superhero ironMan = SuperheroBuilder.getIronMan();
        Superhero hulk = SuperheroBuilder.getHulk();
        superheroRepository.saveAll(List.of(hulk, spiderMan, ironMan));

        List<Superhero> superheroes = superheroRepository.findByNameContaining("Man");

        assertEquals(2, superheroes.size());
        assertEquals("Spider Man", superheroes.get(0).getName());
        assertEquals("Iron Man", superheroes.get(1).getName());
    }
}
