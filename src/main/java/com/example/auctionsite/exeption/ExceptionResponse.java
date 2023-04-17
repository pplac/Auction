package com.example.auctionsite.exeption;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ExceptionResponse {

    private String errorMessage;
    private int errorCode;
    private LocalDateTime errorTimestamp;


}
