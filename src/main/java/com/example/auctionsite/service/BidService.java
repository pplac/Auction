package com.example.auctionsite.service;


import com.example.auctionsite.exeption.BidNotFoundException;
import com.example.auctionsite.model.BidModel;
import com.example.auctionsite.model.CustomerModel;
import com.example.auctionsite.repositories.BidRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@RequiredArgsConstructor
@Service
@Slf4j
public class BidService {

//    Map<CustomerModel, BidModel> bids = new HashMap<>();
    Set<BidModel> bids = new HashSet<>();

    private final BidRepository bidRepository;
    private CustomerModel customerModel;

    public BidModel createBid(BidModel bid) {
        return bidRepository.save(bid);
    }

    public BidModel getAuctionsBidsById(Long bidId) {
        return bidRepository.findAllByBidId(bidId)
                .orElseThrow(() -> new BidNotFoundException("Bid not found: " + bidId));
    }

    public BigDecimal getWinningBid() {
        return bids.stream()
                .max(Comparator.comparing(BidModel::getBidAmount))
                .get().getBidAmount();

    }

    public void deleteBid(Long bidId) {
        bidRepository.deleteById(bidId);

    }


}
