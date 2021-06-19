package com.example.heroes;


import java.util.List;
import java.util.Optional;

import com.example.heroes.entity.Hero;
import com.example.heroes.service.HeroService;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeroServiceTest {
    
    @Autowired
    private HeroService heroService;

    @Test
    public void getAllHeroes() {
        List<Hero> heroes = heroService.getAllHeroes();

        Assertions.assertEquals(heroes.size(), 6); 
    }

    @Test
    public void getHero() {
        Optional<Hero> hero = heroService.getHero(2L);
        Assertions.assertEquals("SPIDERMAN", hero.get().getName());
    }

    @Test
    public void saveHero() {
        Hero hero = new Hero();
        hero.setId(7L);
        hero.setName("POPEYE");
        Hero savedHero = heroService.saveHero(hero);
        Assertions.assertEquals(hero.getId(), savedHero.getId());
        Assertions.assertEquals(hero.getName(), savedHero.getName());
        heroService.deleteHero(7L);
    }

    @Test
    public void findByName() {
        List<Hero> heroes = heroService.findByName("MAN");
        Assertions.assertEquals(4, heroes.size());
    }

}
