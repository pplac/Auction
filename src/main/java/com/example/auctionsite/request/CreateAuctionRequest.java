package com.example.auctionsite.request;


import com.example.auctionsite.model.AuctionItemModel;
import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.BidModel;
import com.example.auctionsite.model.CustomerModel;
import com.example.auctionsite.model.enums.Categories;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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
