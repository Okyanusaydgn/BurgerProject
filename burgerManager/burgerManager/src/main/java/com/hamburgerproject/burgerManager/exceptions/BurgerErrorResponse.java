package com.hamburgerproject.burgerManager.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;


// Bu sınıf bir hata durumunda API tarafından döndürelecek olan hata mesajını göstermek için kullanıyoruz.
// Bu sınıf bir hata meydana geldiği zaman bize JSON formatında gösterir. "{ "message": "Burger with given id does not exist" }"
@Data
@AllArgsConstructor
public class BurgerErrorResponse {
    private String message;
}
