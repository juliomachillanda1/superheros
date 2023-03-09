package com.juliomachillanda.superheros.repository;

import com.juliomachillanda.superheros.model.SuperHeros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperherosRepository extends JpaRepository<SuperHeros, Long> {
}
