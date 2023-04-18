package com.example.auctionsite.request;

import com.example.auctionsite.model.enums.Categories;

import javax.persistence.Column;
import java.math.BigDecimal;

public class CreateAuctionItemRequest {

    String auctionItemTitle;
    Categories auctionItemCategory;
    String auctionItemDescription;
    BigDecimal auctionItemInitCost;

}
