package com.example.auctionsite.request;

import com.example.auctionsite.model.CustomerModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter

@RequiredArgsConstructor
public class EditAuctionWithBidRequest {

    Long auctionModelId;
    Long customerModelId;
    BigDecimal bidAmount;
}
