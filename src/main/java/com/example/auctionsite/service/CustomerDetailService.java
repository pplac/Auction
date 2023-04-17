package com.example.auctionsite.service;

import com.example.auctionsite.model.CustomerModel;
import com.example.auctionsite.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CustomerDetailService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String customerName) throws UsernameNotFoundException {
        final Optional<CustomerModel> customer = customerRepository.findByCustomerName(customerName);

        return customer.orElseThrow(() -> new UsernameNotFoundException("Customer not found!"));
    }
}
