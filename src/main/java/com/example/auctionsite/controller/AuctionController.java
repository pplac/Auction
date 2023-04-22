package com.example.auctionsite.controller;


import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.CustomerModel;
import com.example.auctionsite.request.*;
import com.example.auctionsite.service.AuctionService;
import com.example.auctionsite.service.BidService;
import com.example.auctionsite.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auction")
public class AuctionController {

    @Autowired
    private final AuctionService auctionService;
    private final CustomerService customerService;
    private final BidService bidService;

    @PostMapping("/addAuction")
    public void createAuction(@RequestBody CreateAuctionRequest request) {
        auctionService.createAuction(request);
    }

    @GetMapping("/getAll")
    public List<AuctionModel> getAuctionList() {
        return auctionService.getAllAuctions();
    }

    @PostMapping("/getByCategory")
    public List<AuctionModel> getAuctionByCategory(@RequestBody GetAuctionByCategoryRequest request) {
        return auctionService.getAuctionByCategories(request.getAuctionItemCategory());
    }
    //////////
    @GetMapping("/getAllCustomers")
    public List<CustomerModel> getAuctionAllCustomers(@RequestBody GetAllCustomersForAuction request) {
        return auctionService.getAuctionAllCustomersList(request);
    }

//    @PostMapping("/addAuctionBid")
//    public void editAuctionWithBid(@RequestBody EditAuctionWithBidRequest request) {
//        auctionService.editAuctionWithBid(request);
//    }

    @DeleteMapping("/deleteAuction/{id}")
    public void deleteAuction(@PathVariable("id") Long auctionId) {
        auctionService.deleteAuction(auctionId);
    }
}


//
//    @PostMapping
//    public List<AuctionService> getCustomerWinningAuction(@RequestBody CreateBidRequest request) {
//        List


//    public void getEditAuction() {
//
//    }
//
//    public void postEditAuction() {
//
//    }


//
//    public void getAuctionByKeyword() {
//
//    }