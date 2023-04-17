package com.example.auctionsite.controller;


import com.example.auctionsite.model.AuctionItemModel;
import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.BidModel;
import com.example.auctionsite.model.CustomerModel;
import com.example.auctionsite.request.CreateAuctionRequest;
import com.example.auctionsite.request.EditAuctionWithBidRequest;
import com.example.auctionsite.service.AuctionItemService;
import com.example.auctionsite.service.AuctionService;
import com.example.auctionsite.service.BidService;
import com.example.auctionsite.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class AuctionController {

    private AuctionService auctionService;
    private AuctionItemService auctionItemService;

    private CustomerService customerService;

    private BidService bidService;




    public void postAuction(@RequestBody CreateAuctionRequest request) {

        CustomerModel customer = customerService.getCustomerById(request.getCustomerModelId());
        AuctionItemModel auctionItem = auctionItemService.getAuctionItemById(request.getAuctionModelId());
        AuctionModel auction = AuctionModel.builder()
                .auctionId(request.getAuctionModelId())
                .auctionMinimumBid(request.getAuctionMinimumBid())
                .auctionPostDate(request.getAuctionPostDate())
                .auctionEndDate(request.getAuctionEndDate())
                .auctionBids((Set<BidModel>) request.getAuctionBid())
                .auctionItemModel(auctionItem)
                .auctionCustomerList(request.a)
                .build();



    }

    public void getAllAuction() {

    }

    @PostMapping
    public void EditAuctionWithBid(@RequestBody EditAuctionWithBidRequest request) {

        CustomerModel customer = customerService.getCustomerById(request.getCustomerModelId());
        AuctionModel auction = auctionService.getAuctionById(request.getAuctionModelId());
        BidModel bid = BidModel.builder()
                .bidAmount(request.getBidAmount())
                .bidDate(request.getBidDate())
                .auctionModelId(auction)
                .customerModelId(customer)
                .build();
        bidService.createBid(bid);
    }

    public void getEditAuction() {

    }

    public void postEditAuction() {

    }

    public void deleteAuction() {

    }

}
