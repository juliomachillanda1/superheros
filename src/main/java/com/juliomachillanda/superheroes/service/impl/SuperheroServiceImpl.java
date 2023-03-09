package com.juliomachillanda.superheros.service.impl;

import com.juliomachillanda.superheros.model.SuperHeros;
import com.juliomachillanda.superheros.repository.SuperherosRepository;
import com.juliomachillanda.superheros.service.SuperHerosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SuperHerosServiceImpl implements SuperHerosService {

    @Autowired
    private SuperherosRepository superherosRepository;

    @Override
    public SuperHeros create(SuperHeros superHeros) {
        return superherosRepository.save(superHeros);
    }

    @Override
    public SuperHeros update(SuperHeros superHeros) {
        return superherosRepository.save(superHeros);
    }

    @Override
    public SuperHeros findById(Long id) {
       Optional<SuperHeros> superHeroOptional = superherosRepository.findById(id);
    return superHeroOptional.orElse(null);
    }

    @Override
    public List<SuperHeros> findAll() {
        return superherosRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        superherosRepository.deleteById(id);
    }

    public List<String> getBy(String ch){
        StringBuilder st = new StringBuilder();
        List<SuperHeros> listSuperHeros = findAll();
        List matchSuperHeroe = new ArrayList();
        for(SuperHeros superHeroe: listSuperHeros){
            String superHeroeName = superHeroe.getName();
            if(Boolean.FALSE.equals(hasLetter(ch, superHeroeName))){
                matchSuperHeroe.add(superHeroeName);
            }
        }

        return matchSuperHeroe;
    }

    public static boolean hasLetter (String word, String superHeroe){
        Pattern p = Pattern.compile(superHeroe);
        if (word == null)return false;

        Matcher m = p.matcher(word);
        return m.matches();
    }
}
