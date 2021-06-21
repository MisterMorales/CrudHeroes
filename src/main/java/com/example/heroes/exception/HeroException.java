package com.example.heroes.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeroException {
    
    private String errorMessage;
    private String endPoint;
}
