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
    private CustomerRepository userRepository;

    public Customer createUser(final Customer user) {

        if (isUserInvalidByNickname(user)) {
            throw new IllegalArgumentException();
        }
        return userRepository.save(user);
    }

    private boolean isUserInvalidByNickname(final Customer user) {
        return user.getNickmane().length() == 0;
    }

    public List<Customer> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<Customer> getUserById(final Long userId) {
        return userRepository.findById(userId);
    }


}
