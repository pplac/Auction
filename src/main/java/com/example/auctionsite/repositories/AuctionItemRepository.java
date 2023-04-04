package com.example.auctionsite.repositories;

import com.example.auctionsite.model.Auction;
import com.example.auctionsite.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuctionItemRepository extends JpaRepository<Auction, Long> {


        List<Auction> findByCategories(Categories categories);

        List<Auction> findByName(String name);

}
