package com.example.auctionsite.controller;


import com.example.auctionsite.model.AuctionItemModel;
import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.BidModel;
import com.example.auctionsite.model.CustomerModel;
import com.example.auctionsite.model.enums.Role;
import com.example.auctionsite.request.CreateAuctionRequest;
import com.example.auctionsite.request.EditAuctionWithBidRequest;
import com.example.auctionsite.service.AuctionItemService;
import com.example.auctionsite.service.AuctionService;
import com.example.auctionsite.service.BidService;
import com.example.auctionsite.service.CustomerService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class AuctionController {

    private AuctionService auctionService;
    private AuctionItemService auctionItemService;
    private CustomerService customerService;
    private BidService bidService;


    @PostMapping("/")
    public List<AuctionModel> getAuctionList() {
        return auctionService.getAllAuctions();
    }

    @PostMapping
    public void getCreateAuction(@RequestBody CreateAuctionRequest request) {
        auctionService.createAuction(request);

    }

    @PostMapping
    public void editAuctionWithBid(@RequestBody EditAuctionWithBidRequest request) {
        auctionService.editAuctionWithBid(request);
    }

    public


//    public void getEditAuction() {
//
//    }
//
//    public void postEditAuction() {
//
//    }

    @PostMapping
    public void deleteAuction(@PathVariable("id") Long auctionId) {
        auctionService.deleteAuction(auctionId);
//        return;?
    }

}
