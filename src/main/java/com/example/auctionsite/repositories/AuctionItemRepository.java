package com.example.auctionsite.repositories;

import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.AuctionItemModel;
import com.example.auctionsite.model.Categories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuctionItemRepository extends JpaRepository<AuctionItemModel, Long> {


        Page<AuctionItemModel> findAllBy(Pageable pageable);

        List<AuctionItemModel> findByCategories(Categories category);

        List<AuctionItemModel> findByTitle(String title);

}
