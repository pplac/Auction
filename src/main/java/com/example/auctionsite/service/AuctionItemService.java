package com.example.auctionsite.service;

import com.example.auctionsite.model.AuctionItemModel;
import com.example.auctionsite.model.enums.Categories;
import com.example.auctionsite.repositories.AuctionItemRepository;
import com.example.auctionsite.request.CreateAuctionItemRequest;
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



    public AuctionItemModel createAuctionItem(CreateAuctionItemRequest request) {

        AuctionItemModel auctionItem = AuctionItemModel.builder()
                .auctionItemTitle(request.)
                .build();

        return auctionItemRepository.save(auctionItem);
    }

    public AuctionItemModel getAuctionItemById(Long id) {
        Optional<AuctionItemModel> auctionItem = auctionItemRepository.findById(id);
        if (auctionItem.isPresent()) {
            return auctionItemRepository.findById(id).orElse(null);
        } else {
            log.info("Brak przedmiotu");
            return null;
        }
    }

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
