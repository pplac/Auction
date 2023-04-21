package com.example.auctionsite.repositories;

import com.example.auctionsite.model.AuctionModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuctionRepository extends JpaRepository<AuctionModel, Long> {

    Page<AuctionModel> findAll(Pageable pageable);
    List<AuctionModel> findAllByAuctionIsActive (boolean active);

}
