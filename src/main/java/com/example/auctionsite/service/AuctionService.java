package com.example.auctionsite.service;

import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.repositories.AuctionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuctionService {

    private final AuctionRepository auctionRepository;

    public List<AuctionModel> getAllAuctions() {
        return auctionRepository.findAll();
    }

    public void AddAuction(AuctionModel auction) {
        auctionRepository.save(auction);
    }

//    public Auction getAuctionByCategories(Categories categories) {
//        Optional<Auction> auction = auctionRepository.findBy
//    }


}
