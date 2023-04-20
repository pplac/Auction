package com.example.auctionsite.service;

import com.example.auctionsite.model.AuctionItemModel;
import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.CustomerModel;
import com.example.auctionsite.model.enums.Role;
import com.example.auctionsite.repositories.CustomerRepository;
import com.example.auctionsite.request.CreateCustomerRequest;
import com.example.auctionsite.request.CustomerWinningAuctionRequest;
import com.example.auctionsite.request.EditCustomerRequest;
import com.example.auctionsite.request.GetAllAuctionOrCustomers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomerService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;
    private AuctionModel auctionModel;
    private AuctionService auctionService;

    @Override
    public UserDetails loadUserByUsername(String customerName) throws UsernameNotFoundException {
        final Optional<CustomerModel> customer = customerRepository.findByCustomerName(customerName);

        return customer.orElseThrow(() -> new UsernameNotFoundException("Customer not found!"));
    }

    public CustomerModel createCustomer(CreateCustomerRequest request) {

        CustomerModel customer = CustomerModel.builder()
                .customerName(request.getCustomerName())
                .customerPassword(request.getCustomerPassword())
                .customerEmail(request.getCustomerEmail())
                .customerPostalCode(request.getCustomerPostalCode())
                .customerAuctionOwnerList(List.of())
                .customerAuctionList(List.of())
                .customerBids(Set.of())
                .customerItemsWon(List.of())
                .customerRoles(Set.of(Role.ROLE_BUYER))
                .build();

        if (isCustomerInvalid(customer)) {
            throw new IllegalArgumentException();
        }
        return customerRepository.save(customer);
    }

    private boolean isCustomerInvalid(CustomerModel customer) {
        return customer.getCustomerName().length() == 0;
    }

///////////////
    public List<AuctionModel> getCustomerAuctionList(GetAllAuctionOrCustomers request) {
        List<AuctionModel> customerAuctionList = auctionService.getAllAuctions();
        return customerAuctionList.stream()
                .filter(customerAuction -> customerAuction.getAuctionCustomerList().stream()
                        .anyMatch(customer -> customer.getCustomerId().equals(request.getCustomerId())))
                .toList();
    }
    //////////
    public void editCustomerRole(Long customerId) {
        CustomerModel customerChange = customerRepository.findById(customerId).orElseThrow(() ->new RuntimeException());
        customerChange.getCustomerRoles().add(Role.ROLE_SELLER);
        customerRepository.save(customerChange);
    }



    public List<CustomerModel> getAllCustomers() {
        return customerRepository.findAll();
    }

    public CustomerModel getCustomerById(final Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new UsernameNotFoundException("User cannot be found with id: " + customerId));
    }
//
    public CustomerModel getCustomerByEmail(String customerEmail) {
        return customerRepository.findCustomerByCustomerEmail(customerEmail)
                .orElseThrow(() ->new UsernameNotFoundException("User cannot be found with id: " + customerEmail));
    }
//
    public List<CustomerModel> getCustomerByKeyword(String keyword) {
        return customerRepository.findAllByCustomerNameContains(keyword);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

}

