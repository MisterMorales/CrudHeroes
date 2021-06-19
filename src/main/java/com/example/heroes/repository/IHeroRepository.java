package com.example.heroes.repository;

import com.example.heroes.entity.Hero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHeroRepository extends JpaRepository<Hero, Long>{
    
}
