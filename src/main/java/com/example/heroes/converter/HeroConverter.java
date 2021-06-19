package com.example.heroes.converter;

import com.example.heroes.entity.Hero;
import com.example.heroes.model.HeroDTO;

public class HeroConverter {

    public Hero dtoToHero(HeroDTO heroDTO) {
        Hero hero = new Hero();
        hero.setId(heroDTO.getId());
        hero.setName(heroDTO.getName());
        return hero;
    }

    public HeroDTO heroToDto(Hero hero) {
        HeroDTO heroDTO = new HeroDTO();
        heroDTO.setId(hero.getId());
        heroDTO.setName(hero.getName());
        return heroDTO;
    }
    
}
