package com.example.auctionsite.request;


import com.example.auctionsite.model.AuctionItemModel;
import com.example.auctionsite.model.CustomerModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class CreateAuctionRequest {

    Long auctionModelId;
    double auctionMinimumBid;
    LocalDateTime auctionPostDate;
    LocalDateTime auctionEndDate;
    BigDecimal auctionBid;
    Long auctionItemModelId;
    Long customerSellId;

}
