package com.example.auctionsite.exeption;

public class BidNotFoundException extends RuntimeException{

    public BidNotFoundException(String errorMessage) {
        super("Bid not found: " + errorMessage);
    }

}
