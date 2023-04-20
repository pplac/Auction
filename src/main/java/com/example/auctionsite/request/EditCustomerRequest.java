package com.example.auctionsite.request;

import com.example.auctionsite.annotation.EmailApp;
import com.example.auctionsite.annotation.PostalCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@RequiredArgsConstructor
public class EditCustomerRequest {

    String customerName;
    String customerPassword;
    String customerEmail;
    String customerPostalCode;

}
