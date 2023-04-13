package com.example.auctionsite.service;

import com.example.auctionsite.model.AuctionItemModel;
import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.Categories;
import com.example.auctionsite.repositories.AuctionItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

        if(auctionItemModel.get().getAuctionItemCategory().equals(categories)) {
            return auctionItemRepository.findByCategories(categories).orElse(null);
        } else {
            log.info("there is no such thing");
            return null;
        }
    }

    public void deleteAuctionItem(Long id) {
        auctionItemRepository.deleteById(id);
    }

}
