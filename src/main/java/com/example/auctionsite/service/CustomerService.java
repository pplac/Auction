package com.example.auctionsite.service;

import com.example.auctionsite.model.CustomerModel;
import com.example.auctionsite.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerService  implements UserDetailsService {

    private CustomerRepository customerRepository;


    @Override
    public UserDetails loadUserByUsername(String customerName) throws UsernameNotFoundException {
        final Optional<CustomerModel> customerModel = customerRepository.findByCustomerName(customerName);

        return customerModel.orElseThrow(() -> new UsernameNotFoundException("Customer not found"));
    }

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

    public Optional<CustomerModel> getCustomerById(final Long customerId) {
        return customerRepository.findById(customerId);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }



}
