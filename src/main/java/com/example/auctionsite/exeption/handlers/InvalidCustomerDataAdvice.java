package com.example.auctionsite.exeption.handlers;

import com.example.auctionsite.exeption.ExceptionResponse;
import com.example.auctionsite.exeption.InvalidCustomerDataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class InvalidCustomerDataAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCustomerDataException.class)
    public ExceptionResponse handleInvalidClientDataException(final InvalidCustomerDataException exception) {
        log.error(exception.getMessage());

        return ExceptionResponse.builder()
                .errorMessage(exception.getMessage())
                .errorCode(100)
                .errorTimestamp(LocalDateTime.now())
                .build();
    }

}
