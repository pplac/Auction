package com.example.auctionsite.service;


import com.example.auctionsite.exeption.BidNotFoundException;
import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.BidModel;
import com.example.auctionsite.model.CustomerModel;
import com.example.auctionsite.repositories.BidRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class BidService {

    //    Map<CustomerModel, BidModel> bids = new HashMap<>();
    private Set<BidModel> bids = new HashSet<>();
    private final BidRepository bidRepository;
    private CustomerModel customerModel;


    public BidModel createBid(BidModel bid) {
        return bidRepository.save(bid);
    }

    public BidModel getAuctionsBidsById(Long bidId) {
        return bidRepository.findAllByBidId(bidId)
                .orElseThrow(() -> new BidNotFoundException("Bid not found: " + bidId));
    }

    //
    public List<BidModel> getAllBids() {
        return bidRepository.findAll();
    }


}
