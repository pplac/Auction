package com.example.auctionsite.controller;


import com.example.auctionsite.model.AuctionItemModel;
import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.CustomerModel;
import com.example.auctionsite.model.enums.Role;
import com.example.auctionsite.request.CreateCustomerRequest;
import com.example.auctionsite.service.AuctionItemService;
import com.example.auctionsite.service.AuctionService;
import com.example.auctionsite.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

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

    public void createCostumerBid() {

    }

    public void getFindCustomer() {

    }

    public void getAllCustomers() {

    }

    public void deleteCustomer() {

    }


}
