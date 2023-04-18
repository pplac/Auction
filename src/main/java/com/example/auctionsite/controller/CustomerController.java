package com.example.auctionsite.controller;


import com.example.auctionsite.request.CreateBidRequest;
import com.example.auctionsite.request.CreateCustomerRequest;
import com.example.auctionsite.service.AuctionItemService;
import com.example.auctionsite.service.AuctionService;
import com.example.auctionsite.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private CustomerService customerService;
    private AuctionService auctionService;
    private AuctionItemService auctionItemService;

    @PostMapping
    public void createCustomer(@RequestBody CreateCustomerRequest request) {
        customerService.createCustomer(request);

    }

    public void getEditCustomer() {

    }

    public void postEditCustomer() {

    }
@PostMapping
    public void createCostumerWinningBid(@RequestBody CreateBidRequest request) {

    }

    public void getFindCustomer() {

    }

    public void getAllCustomers() {

    }

    public void deleteCustomer() {

    }


}
