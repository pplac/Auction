package com.example.auctionsite.controller;


import com.example.auctionsite.model.AuctionItemModel;
import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.BidModel;
import com.example.auctionsite.model.CustomerModel;
import com.example.auctionsite.model.enums.Categories;
import com.example.auctionsite.model.enums.Role;
import com.example.auctionsite.request.*;
import com.example.auctionsite.service.AuctionItemService;
import com.example.auctionsite.service.AuctionService;
import com.example.auctionsite.service.BidService;
import com.example.auctionsite.service.CustomerService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public List<AuctionModel> getAuctionByCategory(@RequestBody GetAuctionByCategoryRequest request){
        return auctionService.getAuctionByCategories(request.getAuctionItemCategory());
    }
//////////
    @PostMapping("/auctionCustomers")
    public Set<CustomerModel> getAuctionCustomers(@RequestBody GetAllAuctionOrCustomers request){
        return auctionService.getAllAuctionCustomers(request);
    }

    @PostMapping("/addAuction")
    public void createAuction(@RequestBody CreateAuctionRequest request) {
        auctionService.createAuction(request);

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