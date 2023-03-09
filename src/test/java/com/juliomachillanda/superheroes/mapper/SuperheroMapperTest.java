package com.juliomachillanda.superheroes.mapper;

import com.juliomachillanda.superheroes.builder.SuperheroBuilder;
import com.juliomachillanda.superheroes.domain.Superhero;
import com.juliomachillanda.superheroes.dto.SuperheroDTO;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class SuperheroMapperTest {

    private final SuperheroMapper superheroMapper = Mappers.getMapper(SuperheroMapper.class);

    @Test
    public void testEntityToDto() {
        Superhero superhero = SuperheroBuilder.getIronMan();
        superhero.setId(1L);

        SuperheroDTO superheroDTO = superheroMapper.entityToDto(superhero);

        assertNotNull(superheroDTO);
        assertEquals(1, superheroDTO.getId());
        assertEquals("Iron Man", superheroDTO.getName());
        assertEquals("Suit of armor", superheroDTO.getSuperpower());
    }

    @Test
    public void testDtoToEntity() {
        SuperheroDTO superheroDTO = new SuperheroDTO();
        superheroDTO.setId(1L);
        superheroDTO.setName("Iron Man");
        superheroDTO.setSuperpower("Suit of armor");

        Superhero superhero = superheroMapper.dtoToEntity(superheroDTO);

        assertNotNull(superhero);
        assertEquals(1, superhero.getId());
        assertEquals("Iron Man", superhero.getName());
        assertEquals("Suit of armor", superhero.getSuperpower());
    }

    @Test
    public void testEntitiesToDtos() {
        Superhero spiderMan = SuperheroBuilder.getSpiderMan();
        Superhero ironMan = SuperheroBuilder.getIronMan();

        List<SuperheroDTO> superheroes = superheroMapper.entitiesToDtos(List.of(spiderMan, ironMan));

        assertEquals(2, superheroes.size());
        assertEquals("Spider Man", superheroes.get(0).getName());
        assertEquals("Iron Man", superheroes.get(1).getName());
    }
}
