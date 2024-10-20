package com.hamburgerproject.burgerManager.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;


// Burger ile ilgili özel hataları fırlatmak için kullanıyoruz.
// Hata mesajıyla birlikte HTTP durum kodunu da gösterir.  "throw new BurgerException("Burger with given id does not exist", HttpStatus.NOT_FOUND);"

@Getter
public class BurgerException extends RuntimeException {

    private HttpStatus httpStatus;

    public BurgerException(String message, HttpStatus httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }

}
