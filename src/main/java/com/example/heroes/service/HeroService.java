package com.example.heroes.service;

import java.util.List;
import java.util.Optional;

import com.example.heroes.annotation.Timer;
import com.example.heroes.entity.Hero;
import com.example.heroes.repository.IHeroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroService {
    
    @Autowired
    private IHeroRepository heroRepository;

    @Timer
    public List<Hero> getAllHeroes() {
        return heroRepository.findAll();
    }

    @Timer
    public Optional<Hero> getHero(Long id) {
        return heroRepository.findById(id);
    }

    @Timer
    public Hero saveHero(Hero hero) {
        return heroRepository.save(hero);
    }

    @Timer
    public void deleteHeroes() {
        heroRepository.deleteAll();
    }

    @Timer
    public void deleteHero(Long id) {
        Optional<Hero> hero = heroRepository.findById(id);
        if (hero.isPresent()) {
            heroRepository.delete(hero.get());
        }
    }

    @Timer
    public List<Hero> findByName(String name) {
        return heroRepository.findByNameContaining(name);
    }

}
