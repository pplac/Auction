package com.example.auctionsite.repositories;

import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.CustomerModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuctionRepository extends JpaRepository<AuctionModel, Long> {

    Page<AuctionModel> findAll(Pageable pageable);

    List<AuctionModel> findAllByCustomerAuctionList(Long customerId);

    List<AuctionModel> findAllByAuctionIsActive (boolean active);

}
