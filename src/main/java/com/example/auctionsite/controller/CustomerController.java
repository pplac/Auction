package com.example.auctionsite.controller;


import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.request.*;
import com.example.auctionsite.service.AuctionItemService;
import com.example.auctionsite.service.AuctionService;
import com.example.auctionsite.service.BidService;
import com.example.auctionsite.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;
    private AuctionService auctionService;
    private AuctionItemService auctionItemService;
    private BidService bidService;

    @PostMapping("/addCustomer")
    public void createCustomer(@RequestBody CreateCustomerRequest request) {
        customerService.createCustomer(request);
    }

    @PostMapping("/winningAuction")
    public List<AuctionModel> getCustomerWinningAuction(@RequestBody CustomerWinningAuctionRequest request) {
        List<AuctionModel> allAuctions = auctionService.getAllAuctions();
        return allAuctions.stream()
                .filter(auction -> bidService.getWinningBid(auction.getAuctionBids()).getCustomerModelId().getCustomerId() == request.getCustomerId())
                .collect(Collectors.toList());
    }

    @PostMapping("/createItem")
    public void createAuctionItem(@RequestBody CreateAuctionItemRequest request) {
        auctionItemService.createAuctionItem(request);
    }
///////////
    @PostMapping("/getAuctionList")
    public List<AuctionModel> getCustomerAuctionList(@RequestBody GetAllAuctionOrCustomers request) {
        return customerService.getCustomerAuctionList(request);
    }

    @PostMapping("/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable("id") Long customerId) {
        customerService.deleteCustomer(customerId);
    }
}


//
//    @GetMapping
//    public void getEditCustomer(@PathVariable("id") Long cusromerId,
//                                @RequestBody EditCustomerRequest request) {
//    }

//    public void postEditCustomer() {
//    }

//    //
//    public void getCustomerByEmail() {
//
//    }
//
//    //
//    public void getCustomerByEmail() {
//
//    }