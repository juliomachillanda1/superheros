package com.juliomachillanda.superheroes.mapper;

import com.juliomachillanda.superheroes.domain.Superhero;
import com.juliomachillanda.superheroes.dto.SuperheroDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface  SuperheroMapper {

    SuperheroDTO entityToDto(Superhero superhero);

    Superhero dtoToEntity(SuperheroDTO superheroDTO);

    List<SuperheroDTO> entitiesToDtos(List<Superhero> superheroes);

}
