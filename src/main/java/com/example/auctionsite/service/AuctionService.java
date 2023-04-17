package com.example.auctionsite.service;

import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.repositories.AuctionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class AuctionService {

    private final AuctionRepository auctionRepository;

//    Map<AuctionItemModel, BidModel>

    public List<AuctionModel> getAllAuctions() {
        return auctionRepository.findAll();
    }

    public void AddAuction(AuctionModel auctionModel) {
        auctionRepository.save(auctionModel);
    }

    public AuctionModel getAuctionById(Long id) {
        Optional<AuctionModel> auction = auctionRepository.findById(id);
        if (auction.isPresent()) {
            return auctionRepository.findById(id).orElse(null);
        } else {
            log.info("nie ma takiej aukcji");
            return null;
        }
//        auction.ifPresentOrElse(auctionModel -> auctionRepository.findById(id), () -> log.info("nie ma takiej aukcji"));
//        return null;
    }

    public void deleteAuction(Long id) {
        auctionRepository.deleteById(id);
    }


}
