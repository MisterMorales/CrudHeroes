package com.example.heroes.repository;

import java.util.List;

import com.example.heroes.entity.Hero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHeroRepository extends JpaRepository<Hero, Long>{
    List<Hero> findByNameContaining(String name);
}
