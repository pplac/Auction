package com.example.auctionsite.service;


import com.example.auctionsite.model.BidModel;
import com.example.auctionsite.repositories.BidRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class BidService {


    private final BidRepository bidRepository;

    public void addBid(BidModel bid) {
        bidRepository.save(bid);
    }

//    public void getHighestBit() {
//        double highestBid = aucitonBids.st
//    }

}
