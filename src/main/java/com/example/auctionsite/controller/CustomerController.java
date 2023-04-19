package com.example.auctionsite.controller;


import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.request.CreateBidRequest;
import com.example.auctionsite.request.CreateCustomerRequest;
import com.example.auctionsite.request.CustomerWinningAuctionRequest;
import com.example.auctionsite.request.EditCustomerRequest;
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

    @PostMapping
    public void createCustomer(@RequestBody CreateCustomerRequest request) {
        customerService.createCustomer(request);
    }

    //
    @GetMapping
    public void getEditCustomer(@PathVariable("id") Long cusromerId,
                                @RequestBody EditCustomerRequest request) {

    }

    //
    public void postEditCustomer() {

    }

    //
    @PostMapping("/winningAuction")
    public List<AuctionModel> getCustomerWinningAuction(@RequestBody CustomerWinningAuctionRequest request) {
        List<AuctionModel> allAuctions = auctionService.getAllAuctions();
        return allAuctions.stream()
                .filter(auction -> bidService.getWinningBid(auction.getAuctionBids()).getCustomerModelId().getCustomerId() == request.getCustomerId())
                .collect(Collectors.toList());
    }

//    //
//    public void getCustomerByEmail() {
//
//    }
//
//    //
//    public void getCustomerByEmail() {
//
//    }


    @PostMapping
    public void deleteCustomer(@PathVariable("id") Long customerId) {
        customerService.deleteCustomer(customerId);
    }


}
