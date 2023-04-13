package com.example.auctionsite.service;

import com.example.auctionsite.model.AuctionItemModel;
import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.Categories;
import com.example.auctionsite.repositories.AuctionItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuctionItemService {

    private final AuctionItemRepository auctionItemRepository;

    private List<AuctionItemModel> auctionItemModelList;

    public void addAuctionItem(AuctionItemModel auctionItem) {
        auctionItemRepository.save(auctionItem);
    }

    public AuctionItemModel getAuctionItemByCategories(Categories categories) {
        Optional<AuctionItemModel> auctionItemModel = auctionItemRepository.findByCategories(categories);

        auctionItemModel.

                get().getAuctionItemCategory()
    }

}
