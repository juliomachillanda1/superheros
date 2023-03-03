package com.juliomachillanda.superheros.repository;

import com.juliomachillanda.superheros.model.superheros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface superherosRepository extends JpaRepository<superheros, Long> {
}
