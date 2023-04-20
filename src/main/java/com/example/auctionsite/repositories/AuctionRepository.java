package com.example.auctionsite.repositories;

import com.example.auctionsite.model.AuctionItemModel;
import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.CustomerModel;
import com.example.auctionsite.model.enums.Categories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AuctionRepository extends JpaRepository<AuctionModel, Long> {

    Page<AuctionModel> findAll(Pageable pageable);


    List<AuctionModel> findAllByAuctionIsActive (boolean active);

}
