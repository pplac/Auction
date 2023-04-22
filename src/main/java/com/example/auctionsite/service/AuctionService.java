package com.example.auctionsite.service;

import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.BidModel;
import com.example.auctionsite.model.CustomerModel;
import com.example.auctionsite.model.enums.Categories;
import com.example.auctionsite.repositories.AuctionRepository;
import com.example.auctionsite.request.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;
    private CustomerService customerService;
    private BidService bidService;

    public AuctionModel createAuction(CreateAuctionRequest request) {

        CustomerModel customer = customerService.getCustomerById(request.getAuctionCustomerOwnerId());
        AuctionModel auction = AuctionModel.builder()
                .auctionCustomerOwnerId(customer)
                .auctionMinimumBid(request.getAuctionMinimumBid())
                .auctionTitle(request.getAuctionTitle())
                .auctionItemCategory(request.getAuctionItemCategory())
                .auctionItemDescription(request.getAuctionItemDescription())
                .auctionItemInitCost(request.getAuctionItemInitCost())
                .auctionPostDate(LocalDateTime.now())
                .daysAuctionIsActive(request.getDaysAuctionIsActive())
                .auctionEndDate(LocalDateTime.now().plusDays(request.getDaysAuctionIsActive()))
                .build();

        return auctionRepository.save(auction);
    }

    public List<AuctionModel> getAllAuctions() {
        return auctionRepository.findAll();
    }

    public List<CustomerModel> getAuctionAllCustomersList(GetAllCustomersForAuction auctionIdRequest) {
        List<CustomerModel> auctionCustomersList = customerService.getAllCustomers();
        return auctionCustomersList.stream()
                .filter(auctionCustomers -> auctionCustomers.getCustomerAuctionList().stream()
                        .anyMatch(auction -> auction.getAuctionId().equals(auctionIdRequest)))
                .toList();
    }


//    public void editAuctionWithBid(EditAuctionWithBidRequest request) {
//        CustomerModel customer = customerService.getCustomerById(request.getCustomerModelId());
//        AuctionModel auction = auctionService.getAuctionById(request.getAuctionModelId());
//        BidModel bid = BidModel.builder()
//                .bidAmount(request.getBidAmount())
//                .bidDate(request.getBidDate())
//                .auctionModelId(auction)
//                .customerModelId(customer)
//                .build();
//
//        BidModel bidModel = bidService.createBid(bid);
//        auction.getAuctionBids().add(bidModel);
//        auction.getAuctionCustomerList().add(customer);
//        auctionRepository.save(auction);
//    }

//    public CustomerModel getWinningBid(AuctionModel auctionModel) {
//        Set<BidModel> auctionBids = auctionModel.getAuctionBids();
//        BidModel winningBid = bidService.getWinningBid(auctionBids);
//
//        return winningBid.getCustomerModelId();
//    }

    public AuctionModel getAuctionById(Long id) {
        Optional<AuctionModel> auction = auctionRepository.findById(id);
        if (auction.isPresent()) {
            return auctionRepository.findById(id).orElse(null);
        } else {
            log.info("nie ma takiej aukcji");
            return null;
        }
    }

    public List<AuctionModel> getAuctionByCategories(Categories categories) {
        List<AuctionModel> allAuctionsByCategory = auctionRepository.findAll();
        return allAuctionsByCategory.stream()
                .filter(auctionItem -> auctionItem.getAuctionItemCategory() == categories)
                .collect(Collectors.toList());
    }

//        auction.ifPresentOrElse(auctionModel -> auctionRepository.findById(id), () -> log.info("nie ma takiej aukcji"));
//        return null;

//    public List<AuctionModel> getAuctionByKeyword(String keyword) {
//        return auctionRepository.findAllByAuctionTitleContains(keyword);
//    }

    public void deleteAuction(Long id) {
        auctionRepository.deleteById(id);
    }
}
