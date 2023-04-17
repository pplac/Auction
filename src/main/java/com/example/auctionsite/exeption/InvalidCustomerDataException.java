package com.example.auctionsite.exeption;

public class InvalidCustomerDataException extends RuntimeException{

    public InvalidCustomerDataException(String errorMessage) {
        super("Customer creation failed: " + errorMessage);
    }

}
