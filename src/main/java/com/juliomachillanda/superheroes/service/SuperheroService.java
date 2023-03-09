package com.juliomachillanda.superheros.service;

import com.juliomachillanda.superheros.model.SuperHeros;

import java.util.List;

public interface SuperHerosService {

    SuperHeros create(SuperHeros superHeros);

    SuperHeros update(SuperHeros superHeros);

    SuperHeros findById(Long id);

    List<SuperHeros> findAll();

    void delete(Long id);

    List<String> getBy(String ch);

}
