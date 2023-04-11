package com.example.auctionsite.service;

import com.example.auctionsite.model.Customer;
import com.example.auctionsite.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(final Customer customer) {

        if (isCustomerInvalidByName(customer)) {
            throw new IllegalArgumentException();
        }
        return customerRepository.save(customer);
    }

    private boolean isCustomerInvalidByName(final Customer customer) {
        return customer.getCustomerName().length() == 0;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerByName(final Long customerId) {
        return customerRepository.findById(customerId);
    }


}
