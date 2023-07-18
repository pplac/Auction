package com.example.auctionsite.repositories;

import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {

    Optional<CustomerModel> findByCustomerName(String customerName);
    List<CustomerModel> findAllByCustomerNameContains(String keyword);
    Optional<CustomerModel> findCustomerByCustomerEmail (String customerEmail);
}
