package com.example.heroes.controller;

import java.util.List;

import com.example.heroes.entity.Hero;
import com.example.heroes.model.HeroDTO;
import com.example.heroes.service.HeroService;

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
    private HeroService heroService;

    @GetMapping("/heroes")
    public ResponseEntity<List<HeroDTO>> getAllHeroes() {
            List<HeroDTO> heroes = heroService.getAllHeroes();

            if (heroes.isEmpty() || heroes.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(heroes, HttpStatus.OK);
    }

    @GetMapping("/heroes/{id}")
    public ResponseEntity<HeroDTO> getHero(@PathVariable Long id) {
            HeroDTO hero = heroService.getHero(id);

            if(hero != null){
                return new ResponseEntity<>(hero, HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/heroes")
    public ResponseEntity<HeroDTO> saveHero(@RequestBody Hero hero) {
            return new ResponseEntity<>(heroService.saveHero(hero), HttpStatus.CREATED);
    }

    @PutMapping("/heroes")
    public ResponseEntity<HeroDTO> updateHero(@RequestBody Hero hero) {
            return new ResponseEntity<>(heroService.saveHero(hero), HttpStatus.OK);
    }

    @DeleteMapping("/heroes")
    public ResponseEntity<HttpStatus> deleteHeroes() {
            heroService.deleteHeroes();
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/heroes/{id}")
    public ResponseEntity<HttpStatus> deleteHero(@PathVariable Long id) {
            heroService.deleteHero(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/heroes/find/{name}")
    public ResponseEntity<List<HeroDTO>> findByName(@PathVariable String name) {
            List<HeroDTO> heroes = heroService.findByName(name);

            if (heroes.isEmpty() || heroes.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(heroes, HttpStatus.OK);
    }
    
}
