package com.example.heroes.controller;

import java.util.List;
import java.util.Optional;

import com.example.heroes.entity.Hero;
import com.example.heroes.repository.IHeroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HeroController {
    
    @Autowired
    IHeroRepository heroRepository;

    @GetMapping("/heroes")
    public ResponseEntity<List<Hero>> getAllHeroes() {
        try {
            List<Hero> heroes = heroRepository.findAll();

            if (heroes.isEmpty() || heroes.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(heroes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/heroes/{id}")
    public ResponseEntity<Hero> getHero(@PathVariable Long id) {
        try {
            Optional<Hero> hero = heroRepository.findById(id);

            if(hero.isPresent()){
                return new ResponseEntity<>(hero.get(), HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/heroes")
    public ResponseEntity<Hero> saveHero(@RequestBody Hero hero) {
        try{
            return new ResponseEntity<>(heroRepository.save(hero), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/heroes")
    public ResponseEntity<Hero> updateHero(@RequestBody Hero hero) {
        try {
            return new ResponseEntity<>(heroRepository.save(hero), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/heroes")
    public ResponseEntity<HttpStatus> deleteHeroes() {
        try {
            heroRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/heroes/{id}")
    public ResponseEntity<HttpStatus> deleteHero(@PathVariable Long id) {
        try {
            Optional<Hero> hero = heroRepository.findById(id);
            if (hero.isPresent()) {
                heroRepository.delete(hero.get());
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}