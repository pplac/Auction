package com.example.auctionsite.controller;


import com.example.auctionsite.model.AuctionItemModel;
import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.CustomerModel;
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

    AuctionModel auction = auctionService.getAuctionById(request.getCustomerAuctionList())
    AuctionItemModel auctionItem = auctionItemService.getAuctionItemById(request.);

    CustomerModel customer = CustomerModel.builder()
            .customerName(request.getCustomerName())
            .customerPassword(request.getCustomerPassword())
            .customerEmail(request.getCustomerEmail())
            .customerPostalCode(request.getCustomerPostalCode())
            .build();
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
