package com.example.auctionsite.request;


import com.example.auctionsite.model.AuctionItemModel;
import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.BidModel;
import com.example.auctionsite.model.CustomerModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class CreateAuctionRequest {

    Long auctionCustomerOwnerId;
    BigDecimal auctionMinimumBid;
    LocalDateTime auctionPostDate;
    LocalDateTime auctionEndDate;
    Set<BidModel> auctionBids;
    Long auctionItemModelId;
    Set<CustomerModel> auctionCustomerList;


}
