package com.example.heroes.converter;

import java.util.List;

import com.example.heroes.entity.Hero;
import com.example.heroes.model.HeroDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface HeroConverter {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    HeroDTO toHero(Hero hero);
    List<HeroDTO> toHero(List<Hero> heroes);

    /*public Hero dtoToHero(HeroDTO heroDTO) {
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
    }*/
    
}
