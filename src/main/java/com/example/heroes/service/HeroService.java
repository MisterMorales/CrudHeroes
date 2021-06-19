package com.example.heroes.service;

import java.util.List;
import java.util.Optional;

import com.example.heroes.entity.Hero;
import com.example.heroes.repository.IHeroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroService {
    
    @Autowired
    private IHeroRepository heroRepository;

    public List<Hero> getAllHeroes() {
        return heroRepository.findAll();
    }

    public Optional<Hero> getHero(Long id) {
        return heroRepository.findById(id);
    }

    public Hero saveHero(Hero hero) {
        return heroRepository.save(hero);
    }

    public void deleteHeroes() {
        heroRepository.deleteAll();
    }

    public void deleteHero(Long id) {
        Optional<Hero> hero = heroRepository.findById(id);
        if (hero.isPresent()) {
            heroRepository.delete(hero.get());
        }
    }

    public List<Hero> findByName(String name) {
        return heroRepository.findByNameContaining(name);
    }




}
