package com.example.auctionsite.repositories;

import com.example.auctionsite.model.BidModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BidRepository extends JpaRepository<BidModel, Long> {

    Optional<BidModel> findAllByBidId(Long id);

}
