package com.example.auctionsite.service;

import com.example.auctionsite.model.CustomerModel;
import com.example.auctionsite.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerModel createCustomer(final CustomerModel customer) {

        if (isCustomerInvalid(customer)) {
            throw new IllegalArgumentException();
        }
        return customerRepository.save(customer);
    }

    private boolean isCustomerInvalid(final CustomerModel customer) {
        return customer.getCustomerName().length() == 0;
    }

    public List<CustomerModel> getAllCustomers() {
        return customerRepository.findAll();
    }

    public CustomerModel getCustomerById(final Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new UsernameNotFoundException("User cannot be found with id: " + customerId));
    }

    public List<CustomerModel> getCustomerByKeyword(String keyword) {
        return customerRepository.findAllByCustomerNameContains(keyword);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }


}
