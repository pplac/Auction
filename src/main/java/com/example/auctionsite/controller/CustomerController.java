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

    @PostMapping("/addCustomer")
    public void createCustomer(@RequestBody CreateCustomerRequest request) {
        customerService.createCustomer(request);
    }

//    @GetMapping("/getCustomerById/{id}")
//    public CustomerModel getCustomerById(@PathVariable("id") Long id) {
//        CustomerModel chosenCustomer = customerService.getCustomerById(id);
//        if (chosenCustomer.getCustomerAuctionOwnerList().size() > 0) {
//            customerService.getCustomerById(id);
//        }
//        return customerService.editCustomerRole(chosenCustomer.getCustomerId());
//    }
    ///////sprawdzić
    @GetMapping("/getAllAuctionListForCustomer")
    public List<AuctionModel> getCustomerAuctionList(@RequestBody GetAllAuctionsForCustomerRequest request) {
        return customerService.getAllAuctionListForCustomer(request);
    }
    ///////sprawdzić
//    @GetMapping("/getWonAuctionsForCustomer/{id}")
//    public List<AuctionModel> getCustomerWinAuction(@PathVariable("id") Long id,
//                                                    @RequestBody GetAllAuctionsForCustomer request) {
//        return customerAuctions.stream()
//                .filter(auction -> bidService.
//                .collect(Collectors.toList());
//    }

    @DeleteMapping ("/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable("id") Long customerId) {
        customerService.deleteCustomer(customerId);
    }

}


