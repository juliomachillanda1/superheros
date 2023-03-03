package com.juliomachillanda.superheros.repository;

import com.juliomachillanda.superheros.model.SuperherosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperherosRepository extends JpaRepository<SuperherosEntity, Long> {
}
