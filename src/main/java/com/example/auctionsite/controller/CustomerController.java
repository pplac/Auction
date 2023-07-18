package com.example.auctionsite.controller;

import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.CustomerModel;
import com.example.auctionsite.request.*;
import com.example.auctionsite.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/getAllCustomers")
    public List<CustomerModel> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/addCustomer")
    public void createCustomer(@RequestBody CreateCustomerRequest request) {
        customerService.createCustomer(request);
    }

    @GetMapping("/getCustomerById/{id}")
    public CustomerModel getCustomerById(@PathVariable("id") Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/getAllAuctionListForCustomer")
    public List<AuctionModel> getCustomerAuctionList(@RequestBody GetAllAuctionsForCustomerRequest request) {
        return customerService.getAllAuctionListForCustomer(request);
    }

    @DeleteMapping ("/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable("id") Long customerId) {
        customerService.deleteCustomer(customerId);
    }
}


