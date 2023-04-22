package com.example.auctionsite.request;


import com.example.auctionsite.model.CustomerModel;
import com.example.auctionsite.model.enums.Categories;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
public class CreateAuctionRequest {

    Long auctionCustomerOwnerId;
    BigDecimal auctionMinimumBid;
    String auctionTitle;
    Categories auctionItemCategory;
    String auctionItemDescription;
    BigDecimal auctionItemInitCost;
    int daysAuctionIsActive;

}
