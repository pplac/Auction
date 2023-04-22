package com.example.auctionsite.controller;


import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.CustomerModel;
import com.example.auctionsite.request.*;
import com.example.auctionsite.service.AuctionService;
import com.example.auctionsite.service.BidService;
import com.example.auctionsite.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final AuctionService auctionService;
    private final BidService bidService;

    @GetMapping("/getAllCustomers")
    public List<CustomerModel> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/getCustomer/{id}")
    public CustomerModel getCustomerById(@PathVariable("id") Long id) {
        CustomerModel chosenCustomer = customerService.getCustomerById(id);
        if (chosenCustomer.getCustomerAuctionOwnerList().size() > 0) {
            customerService.getCustomerById(id);
        }
        return customerService.editCustomerRole(chosenCustomer.getCustomerId());
    }

    @PostMapping("/addCustomer")
    public void createCustomer(@RequestBody CreateCustomerRequest request) {
        customerService.createCustomer(request);
    }
/////////////////Cannot invoke "com.example.auctionsite.service.AuctionService.getAllAuctions()"
// because "this.auctionService" is null
    @GetMapping("/getCustomerAuctionsListById")
    public List<AuctionModel> getCustomerAuctionList(@RequestBody GetAllAuctionsForCustomer request) {
        return customerService.getCustomerAuctionsList(request);
    }
//pozniej
    @GetMapping("/getCustomerWinAuction/{id}")
    public List<AuctionModel> getCustomerWinAuction(@PathVariable("id") Long id,
                                                    @RequestBody GetAllAuctionsForCustomer request) {
        List<AuctionModel> customerAuctions = auctionService.getAllAuctions();
        return customerAuctions.stream()
                .filter(auction -> bidService.getWinningBid(auction.getAuctionBids()).getCustomerModelId().getCustomerId() == request.getCustomerId())
                .collect(Collectors.toList());
    }
//////////////////
    @PostMapping("/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable("id") Long customerId) {
        customerService.deleteCustomer(customerId);
    }

}


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