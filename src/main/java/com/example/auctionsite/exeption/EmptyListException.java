package com.example.auctionsite.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmptyListException extends RuntimeException{

    public EmptyListException(String message) {
        super(message);
    }

}
