package com.example.auctionsite.repositories;

import com.example.auctionsite.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {

    List<CustomerModel> findByCustomerName(String customerName);



}
