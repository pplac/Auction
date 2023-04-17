package com.example.auctionsite.repositories;

import com.example.auctionsite.model.WinningBidModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WinningBidRepository extends JpaRepository<WinningBidModel, Long> {

    List<WinningBidModel> findAllByBidCustomerId(Long id);

}
