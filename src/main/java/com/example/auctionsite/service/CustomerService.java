package com.example.auctionsite.service;

import com.example.auctionsite.exeption.CreateCustomerException;
import com.example.auctionsite.exeption.CustomerNotFoundException;
import com.example.auctionsite.exeption.EmptyListException;
import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.CustomerModel;
import com.example.auctionsite.model.enums.Role;
import com.example.auctionsite.repositories.AuctionRepository;
import com.example.auctionsite.repositories.CustomerRepository;
import com.example.auctionsite.request.CreateAuctionRequest;
import com.example.auctionsite.request.CreateCustomerRequest;
import com.example.auctionsite.request.GetAllAuctionsForCustomer;
import com.example.auctionsite.request.GetAllCustomersForAuction;
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
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomerService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AuctionRepository auctionRepository;


    @Override
    public UserDetails loadUserByUsername(String customerName) throws UsernameNotFoundException {
        final Optional<CustomerModel> customer = customerRepository.findByCustomerName(customerName);

        return customer.orElseThrow(() -> new UsernameNotFoundException("Customer not found!"));
    }

    public List<CustomerModel> getAllCustomers() {
        return customerRepository.findAll();
    }

    public CustomerModel getCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer cannot be found with id: " + customerId));
    }

    public void createCustomer(CreateCustomerRequest request) {

        CustomerModel customer = CustomerModel.builder()
                .customerName(request.getCustomerName())
                .customerPassword(request.getCustomerPassword())
                .customerEmail(request.getCustomerEmail())
                .customerPostalCode(request.getCustomerPostalCode())
                .customerRoles(Set.of(Role.ROLE_USER))
                .build();

        if (isCustomerInvalid(customer)) {
            throw new CreateCustomerException("Customer can not be create");
        }
        customerRepository.save(customer);
    }

    private boolean isCustomerInvalid(CustomerModel customer) {
//        return customer.getCustomerName().length() == 0;
        boolean customerData =
                customer.getCustomerName().length() == 0 ||
                        customer.getCustomerPassword().length() == 0 ||
                        customer.getCustomerEmail().length() == 0 ||
                        customer.getCustomerPostalCode().length() == 0;
        return customerData;
    }

    public List<AuctionModel> getAllAuctionListForCustomer(GetAllAuctionsForCustomer request) {
        List<AuctionModel> auction = auctionRepository.findAll();
        return auction.stream()
                .filter(oneAuction -> oneAuction.getAuctionCustomerList().stream()
                        .anyMatch(auctionCustomer -> auctionCustomer.getCustomerId().equals(request.getCustomerId())))
                .toList();
//        List<CustomerModel> customer = customerRepository.findAll();
//        return customer.stream()
//                .filter(thisCustomer -> thisCustomer.getCustomerId().equals(request.getCustomerId()))
//                .map(CustomerModel::getCustomerAuctionList)
//                .toList();
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

