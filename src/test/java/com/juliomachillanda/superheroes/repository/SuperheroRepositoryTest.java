package com.juliomachillanda.superheroes;

import com.juliomachillanda.superheroes.domain.Superhero;
import com.juliomachillanda.superheroes.repository.SuperheroRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SuperheroRepositoryTest {

    @Autowired
    private SuperheroRepository superheroeRepository;

    @Test
    public void testSave() {
        Superhero superhero = new Superhero();
        superhero.setName("Spiderman");
        superhero.setSuperpower("Spider senses");
        superheroeRepository.save(superhero);
        assertNotNull(superhero.getId());
    }

    @Test
    public void testFindById() {
        Superhero superhero = new Superhero();
        superhero.setName("Iron Man");
        superhero.setSuperpower("Suit of armor");

        superheroeRepository.save(superhero);

        Optional<Superhero> foundSuperhero = superheroeRepository.findById(superhero.getId());

        assertEquals(superhero.getName(), foundSuperhero.stream().findAny().get().getName());
        assertEquals(superhero.getSuperpower(), foundSuperhero.stream().findAny().get().getSuperpower());
    }

    @Test
    public void testFindAll() {
        Superhero superhero1 = new Superhero();
        superhero1.setName("Wonder Woman");
        superhero1.setSuperpower("Super strength");

        superheroeRepository.save(superhero1);

        Superhero superhero2 = new Superhero();
        superhero2.setName("Batman");
        superhero2.setSuperpower("Utility belt");

        superheroeRepository.save(superhero2);

        List<Superhero> superheroes = superheroeRepository.findAll();

        assertEquals(2, superheroes.size());
        assertEquals(superhero1.getName(), superheroes.get(0).getName());
        assertEquals(superhero2.getName(), superheroes.get(1).getName());
    }

    /*@Test
    @Ignore
    public void testDeleteById() {
        SuperHeros superhero = new SuperHeros();
        superhero.setName("Superman");
        superhero.setSuperPower("Flying and super strength");

        superherosRepository.deleteById(superhero.getId());

        assertNull(superherosRepository.findById(superhero.getId()));
    }*/
}
