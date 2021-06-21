package com.example.heroes.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class HeroExceptionHandler {

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public @ResponseBody HeroException authenticationException(final AuthenticationException ex, final HttpServletRequest request) {
        
        HeroException error = new HeroException();
        error.setErrorMessage(ex.getMessage());
        error.setEndPoint(request.getRequestURI());

        return error;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody HeroException handleException(final Exception ex, final HttpServletRequest request) {
        
        HeroException error = new HeroException();
        error.setErrorMessage(ex.getMessage());
        error.setEndPoint(request.getRequestURI());

        return error;
    }
    
}
