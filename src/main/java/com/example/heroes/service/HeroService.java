package com.example.heroes.service;

import java.util.List;
import java.util.Optional;

import com.example.heroes.annotation.Timer;
import com.example.heroes.converter.HeroConverter;
import com.example.heroes.entity.Hero;
import com.example.heroes.model.HeroDTO;
import com.example.heroes.repository.IHeroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroService {
    
    @Autowired
    private IHeroRepository heroRepository;

    @Autowired
    private HeroConverter heroConverter;

    @Timer
    public List<HeroDTO> getAllHeroes() {
        return heroConverter.toHero(heroRepository.findAll());
    }

    @Timer
    public HeroDTO getHero(Long id) {
        return heroConverter.toHero(heroRepository.findById(id).get());
    }

    @Timer
    public HeroDTO saveHero(Hero hero) {
        return heroConverter.toHero(heroRepository.save(hero));
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
    public List<HeroDTO> findByName(String name) {
        return heroConverter.toHero(heroRepository.findByNameContaining(name));
    }

}
