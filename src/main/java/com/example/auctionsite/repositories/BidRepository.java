package com.example.auctionsite.repositories;

import com.example.auctionsite.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface BidRepository extends JpaRepository<Bid, Long> {

    List<Bid> bidList = new ArrayList<>();

}
