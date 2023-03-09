package com.juliomachillanda.superheroes.controller;

import com.juliomachillanda.superheroes.builder.SuperheroBuilder;
import com.juliomachillanda.superheroes.domain.Superhero;
import com.juliomachillanda.superheroes.dto.SuperheroDTO;
import com.juliomachillanda.superheroes.mapper.SuperheroMapper;
import com.juliomachillanda.superheroes.repository.SuperheroRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class SuperheroController extends AbstractFunctionalTest {

    private static final String SUPERHEROES_ENDPOINT = "/superheroes";

    @Autowired
    private SuperheroRepository superheroRepository;

    @Autowired
    private SuperheroMapper superheroMapper;

    @Test
    public void findAllOk() throws Exception {
        Superhero spiderMan = SuperheroBuilder.getSpiderMan();
        Superhero ironMan = SuperheroBuilder.getIronMan();
        Superhero hulk = SuperheroBuilder.getHulk();
        superheroRepository.saveAll(List.of(hulk, spiderMan, ironMan));

        MvcResult mvcResult = mockMvc.perform(get(SUPERHEROES_ENDPOINT))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        List<SuperheroDTO> superheroDTOS = superheroMapper.entitiesToDtos(List.of(hulk, spiderMan, ironMan));
        String expectedSuperheroes = objectMapper.writeValueAsString(superheroDTOS);
        assertEquals(expectedSuperheroes, mvcResult.getResponse().getContentAsString());
    }
}
