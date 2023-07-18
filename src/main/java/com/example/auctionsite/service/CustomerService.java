package com.example.auctionsite.service;

import com.example.auctionsite.exeption.CreateCustomerException;
import com.example.auctionsite.exeption.CustomerNotFoundException;
import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.CustomerModel;
import com.example.auctionsite.model.enums.Role;
import com.example.auctionsite.repositories.AuctionRepository;
import com.example.auctionsite.repositories.CustomerRepository;
import com.example.auctionsite.request.CreateCustomerRequest;
import com.example.auctionsite.request.GetAllAuctionsForCustomerRequest;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
        boolean customerData =
                customer.getCustomerName().length() == 0 ||
                        customer.getCustomerPassword().length() == 0 ||
                        customer.getCustomerEmail().length() == 0 ||
                        customer.getCustomerPostalCode().length() == 0;
        return customerData;
    }

    public List<AuctionModel> getAllAuctionListForCustomer(GetAllAuctionsForCustomerRequest request) {
        List<AuctionModel> auction = auctionRepository.findAll();
        return auction.stream()
                .filter(oneAuction -> oneAuction.getAuctionCustomerList().stream()
                        .anyMatch(auctionCustomer -> auctionCustomer.getCustomerId().equals(request.getCustomerId())))
                .toList();
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}

