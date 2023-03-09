package com.juliomachillanda.superheroes.controller;

import com.juliomachillanda.superheroes.builder.SuperheroBuilder;
import com.juliomachillanda.superheroes.domain.Superhero;
import com.juliomachillanda.superheroes.dto.SuperheroDTO;
import com.juliomachillanda.superheroes.mapper.SuperheroMapper;
import com.juliomachillanda.superheroes.repository.SuperheroRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
public class SuperheroControllerTest extends AbstractFunctionalTest {

    private static final String SUPERHEROES_ENDPOINT = "/superheroes";

    @Autowired
    private SuperheroRepository superheroRepository;

    @Autowired
    private SuperheroMapper superheroMapper;

    @Test
    public void testFindAllOk() throws Exception {
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

    @Test
    public void testCreateOk() throws Exception {
        Superhero spiderMan = SuperheroBuilder.getSpiderMan();
        String payload = objectMapper.writeValueAsString(spiderMan);

        MvcResult mvcResult = mockMvc.perform(post(SUPERHEROES_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();

        SuperheroDTO superheroDTO = superheroMapper.entityToDto(spiderMan);
        superheroDTO.setId(1L);
        String expectedSuperhero = objectMapper.writeValueAsString(superheroDTO);
        assertEquals(expectedSuperhero, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testUpdateOk() throws Exception {
        Superhero spiderMan = SuperheroBuilder.getSpiderMan();
        superheroRepository.save(spiderMan);
        SuperheroDTO spiderManDTO = new SuperheroDTO();
        spiderManDTO.setId(spiderMan.getId());
        spiderManDTO.setName("Spider-Man");
        String payload = objectMapper.writeValueAsString(spiderManDTO);

        MvcResult mvcResult = mockMvc.perform(put(SUPERHEROES_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(payload, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testFindByIdOk() throws Exception {
        Superhero spiderMan = SuperheroBuilder.getSpiderMan();
        superheroRepository.save(spiderMan);

        MvcResult mvcResult = mockMvc.perform(get(SUPERHEROES_ENDPOINT + String.format("/%d", spiderMan.getId())))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        SuperheroDTO superheroDTO = superheroMapper.entityToDto(spiderMan);
        superheroDTO.setId(spiderMan.getId());
        String expectedSuperhero = objectMapper.writeValueAsString(superheroDTO);
        assertEquals(expectedSuperhero, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testFindByIdWhenSuperheroIsNotFound() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get(SUPERHEROES_ENDPOINT.concat("/9")))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Superhero with id 9 not found"));
    }

    @Test
    public void testDeleteByIdOk() throws Exception {
        Superhero spiderMan = SuperheroBuilder.getSpiderMan();
        superheroRepository.save(spiderMan);

        mockMvc.perform(delete(SUPERHEROES_ENDPOINT + String.format("/%d", spiderMan.getId())))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertFalse(superheroRepository.existsById(1L));
    }

    @Test
    public void testFindByNameContainingOk() throws Exception {
        Superhero spiderMan = SuperheroBuilder.getSpiderMan();
        Superhero ironMan = SuperheroBuilder.getIronMan();
        Superhero hulk = SuperheroBuilder.getHulk();
        superheroRepository.saveAll(List.of(hulk, spiderMan, ironMan));

        MvcResult mvcResult = mockMvc.perform(get(SUPERHEROES_ENDPOINT.concat("/search"))
                .param("name", "Man")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        List<SuperheroDTO> superheroDTOS = superheroMapper.entitiesToDtos(List.of(spiderMan, ironMan));
        String expectedSuperheroes = objectMapper.writeValueAsString(superheroDTOS);
        assertEquals(expectedSuperheroes, mvcResult.getResponse().getContentAsString());
    }

}
