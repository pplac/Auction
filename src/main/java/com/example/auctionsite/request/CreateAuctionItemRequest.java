package com.example.auctionsite.request;

import com.example.auctionsite.model.CustomerModel;
import com.example.auctionsite.model.enums.Categories;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.math.BigDecimal;

@Getter
@Setter

@RequiredArgsConstructor
public class CreateAuctionItemRequest {

    String auctionItemTitle;
    Categories auctionItemCategory;
    String auctionItemDescription;
    BigDecimal auctionItemInitCost;

}
