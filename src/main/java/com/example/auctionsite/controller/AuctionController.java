package com.example.auctionsite.controller;


import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.CustomerModel;
import com.example.auctionsite.request.*;
import com.example.auctionsite.service.AuctionItemService;
import com.example.auctionsite.service.AuctionService;
import com.example.auctionsite.service.BidService;
import com.example.auctionsite.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/auction")
public class AuctionController {

    private AuctionService auctionService;
    private AuctionItemService auctionItemService;
    private CustomerService customerService;
    private BidService bidService;


    @PostMapping("/")
    public List<AuctionModel> getAuctionList() {
        return auctionService.getAllAuctions();
    }

    @PostMapping("/byCategory")
    public List<AuctionModel> getAuctionByCategory(@RequestBody GetAuctionByCategoryRequest request) {
        return auctionService.getAuctionByCategories(request.getAuctionItemCategory());
    }

    //////////
    @PostMapping("/auctionCustomers")
    public List<CustomerModel> getAuctionCustomers(@RequestBody GetAllAuctionOrCustomers request) {
        return auctionService.getAuctionCustomersList(request);
    }

    @PostMapping("/addAuction/{customerId}")
    public void createAuction(@PathVariable("customerId") Long customerId,
                              @RequestBody CreateAuctionRequest request) {
        auctionService.createAuction(request,customerId);

    }

    @PostMapping("/addAuctionBid")
    public void editAuctionWithBid(@RequestBody EditAuctionWithBidRequest request) {
        auctionService.editAuctionWithBid(request);
    }

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