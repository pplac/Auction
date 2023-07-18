package com.example.auctionsite.service;

import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.BidModel;
import com.example.auctionsite.model.CustomerModel;
import com.example.auctionsite.model.enums.Categories;
import com.example.auctionsite.model.enums.Role;
import com.example.auctionsite.repositories.AuctionRepository;
import com.example.auctionsite.repositories.CustomerRepository;
import com.example.auctionsite.request.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Service
@Slf4j
public class AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BidService bidService;

    public List<AuctionModel> getAllAuctions() {
        return auctionRepository.findAll();

    }

    public void createAuction(CreateAuctionRequest request) {

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
                .auctionIsActive(LocalDateTime.now().plusDays(request.getDaysAuctionIsActive()).isAfter(LocalDateTime.now()))
                .build();
        customer.getCustomerAuctionOwnerList().add(auction);
        customer.getCustomerRoles().add(Role.ROLE_AUCTIONEER);
        auctionRepository.save(auction);
    }

    /////////DZiAŁA
    public List<List<CustomerModel>> getAllCustomersListForAuction(GetAllCustomersForAuctionRequest request) {
        List<AuctionModel> auction = auctionRepository.findAll();
        return auction.stream()
                .filter(oneAuction -> oneAuction.getAuctionId().equals(request.getAuctionId()))
                .map(AuctionModel::getAuctionCustomerList)
                .toList();
    }

    public void editAuctionWithBid(EditAuctionWithBidRequest request) {
        CustomerModel customer = customerService.getCustomerById(request.getCustomerModelId());
        AuctionModel auction = auctionRepository.getReferenceById(request.getAuctionModelId());

        BidModel bid = BidModel.builder()
                .auctionModelId(auction)
                .customerModelId(customer)
                .bidAmount(request.getBidAmount())
                .bidDate(LocalDateTime.now())
                .build();

        BidModel bidModel = bidService.createBid(bid);
        auction.getAuctionBids().add(bidModel);
        auction.getAuctionCustomerList().add(customer);
        customer.getCustomerAuctionList().add(auction);
        customer.getCustomerBids().add(bid);
        customerRepository.save(customer);
        auctionRepository.save(auction);

    }

    //        public BidModel getWinningBid(GetWinningBid request) {
//        List<AuctionModel> allAuctionsBids = auctionRepository.findAll();
//        allAuctionsBids.stream()
//                .filter(bids -> bids.getAuctionId().equals(request.getAuctionId()))
//                .collect(toList());
//
//        return allAuctionsBids.stream()
//                .max(Comparator.comparing(AuctionModel::getAuctionBids))
//                .collect();
//
//
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
                .collect(toList());
    }

    public List<AuctionModel> getAuctionByKeyword(String request) {
        List<AuctionModel> auctionContains = auctionRepository.findAll();
        return auctionContains.stream()
                .filter(auction -> auction.getAuctionTitle().toUpperCase().contains(request.toUpperCase()))
                .toList();
    }

    public void deleteAuction(Long id) {
        auctionRepository.deleteById(id);
    }
}
