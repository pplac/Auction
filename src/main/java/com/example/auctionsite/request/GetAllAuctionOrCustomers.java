package com.example.auctionsite.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class GetAllAuctionOrCustomers {

    Long auctionId;
    Long customerId;

}
