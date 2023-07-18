package com.example.auctionsite.controller;

import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.CustomerModel;
import com.example.auctionsite.request.*;
import com.example.auctionsite.service.AuctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auction")
public class AuctionController {

    private final AuctionService auctionService;

    @GetMapping("/getAllAuctions")
    public List<AuctionModel> getAuctionList() {
        return auctionService.getAllAuctions();
    }

    @PostMapping("/addAuction")
    public void createAuction(@RequestBody CreateAuctionRequest request) {
        auctionService.createAuction(request);
    }

    @GetMapping("/getByCategory")
    public List<AuctionModel> getAuctionByCategory(@RequestBody GetAuctionByCategoryRequest request) {
        return auctionService.getAuctionByCategories(request.getAuctionItemCategory());
    }

    @GetMapping("/getByKeyword")
    public List<AuctionModel> getAuctionByCategory(@RequestBody GetAuctionByKeywordRequest request) {
        return auctionService.getAuctionByKeyword(request.getKeyword());
    }

    @GetMapping("/getAllCustomersForAuction")
    public List<List<CustomerModel>> getAllCustomersForAuction(@RequestBody GetAllCustomersForAuctionRequest request) {
        return auctionService.getAllCustomersListForAuction(request);
    }

    @PostMapping("/addAuctionBid")
    public void editAuctionWithBid(@RequestBody EditAuctionWithBidRequest request) {
        auctionService.editAuctionWithBid(request);
    }

    @DeleteMapping("/deleteAuction/{id}")
    public void deleteAuction(@PathVariable("id") Long auctionId) {
        auctionService.deleteAuction(auctionId);
    }
}




