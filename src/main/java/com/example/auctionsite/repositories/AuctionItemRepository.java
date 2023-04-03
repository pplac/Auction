package com.example.auctionsite.repositories;

import com.example.auctionsite.model.AuctionItem;
import com.example.auctionsite.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuctionItemRepository extends JpaRepository<AuctionItem, Long> {


        List<AuctionItem> findByCategories(Categories categories);

        List<AuctionItem> findByName(String name);

}