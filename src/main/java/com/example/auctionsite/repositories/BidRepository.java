package com.example.auctionsite.repositories;

import com.example.auctionsite.model.BidModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface BidRepository extends JpaRepository<BidModel, Long> {

    List<BidModel> bidModelList = new ArrayList<>();

}
