package com.example.auctionsite.controller;


import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.BidModel;
import com.example.auctionsite.model.CustomerModel;
import com.example.auctionsite.request.EditAuctionWithBidRequest;
import com.example.auctionsite.service.AuctionService;
import com.example.auctionsite.service.BidService;
import com.example.auctionsite.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuctionController {

    private AuctionService auctionService;

    private CustomerService customerService;

    private BidService bidService;




    public void getAuction() {

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
