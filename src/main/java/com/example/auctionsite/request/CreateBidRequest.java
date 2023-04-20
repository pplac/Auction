package com.example.auctionsite.request;

import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.CustomerModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter

@RequiredArgsConstructor
public class CreateBidRequest {

    BigDecimal bidAmount;
    LocalDateTime bidDate;

}
