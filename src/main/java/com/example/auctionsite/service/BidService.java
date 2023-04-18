package com.example.auctionsite.service;


import com.example.auctionsite.exeption.BidNotFoundException;
import com.example.auctionsite.model.BidModel;
import com.example.auctionsite.repositories.BidRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class BidService {


    private final BidRepository bidRepository;

    public BidModel createBid(BidModel bid) {
        return bidRepository.save(bid);
    }

    public BidModel getAuctionsBidsById(Long bidId) {
        return bidRepository.findAllByBidId(bidId)
                .orElseThrow(() -> new BidNotFoundException("Bid not found: " + bidId));
    }

    public void deleteBid(Long bidId) {
        bidRepository.deleteById(bidId);

    }






}
