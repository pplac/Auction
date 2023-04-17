package com.example.auctionsite.repositories;

import com.example.auctionsite.model.AuctionItemModel;
import com.example.auctionsite.model.enums.Categories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuctionItemRepository extends JpaRepository<AuctionItemModel, Long> {


        Page<AuctionItemModel> findAllBy(Pageable pageable);

        Optional<AuctionItemModel> findByCategories(Categories category);

        List<AuctionItemModel> findByTitle(String title);

}
