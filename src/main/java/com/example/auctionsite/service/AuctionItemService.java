package com.example.auctionsite.service;

import com.example.auctionsite.model.AuctionItemModel;
import com.example.auctionsite.model.enums.Categories;
import com.example.auctionsite.repositories.AuctionItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class AuctionItemService {

    private final AuctionItemRepository auctionItemRepository;


    public List<AuctionItemModel> getAuctionItemList() {
        return auctionItemRepository.findAll();
    }

    public void addAuctionItem(AuctionItemModel auctionItem) {
        auctionItemRepository.save(auctionItem);
    }

    public AuctionItemModel getAuctionItemByCategories(Categories categories) {
        Optional<AuctionItemModel> auctionItemModel = auctionItemRepository.findByCategories(categories);
        auctionItemModel.stream()
                .filter(auctionItem -> auctionItem.getAuctionItemCategory() == categories)
                .collect(Collectors.toList());
        return null;
    }

    public void deleteAuctionItem(Long id) {
        auctionItemRepository.deleteById(id);
    }

}
