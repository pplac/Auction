package com.example.auctionsite.controller;


import com.example.auctionsite.model.AuctionItemModel;
import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.BidModel;
import com.example.auctionsite.model.CustomerModel;
import com.example.auctionsite.request.CreateAuctionRequest;
import com.example.auctionsite.request.EditAuctionWithBidRequest;
import com.example.auctionsite.service.AuctionItemService;
import com.example.auctionsite.service.AuctionService;
import com.example.auctionsite.service.BidService;
import com.example.auctionsite.service.CustomerService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class AuctionController {

    private AuctionService auctionService;
    private AuctionItemService auctionItemService;
    private CustomerService customerService;
    private BidService bidService;


    @PostMapping("/")
    public void getAuctionList(Model model) {
        List<AuctionModel> auctionModelList = auctionService.getAllAuctions();
        model.addAttribute("auctionModel", auctionModelList);
//        return?
    }

    @PostMapping
    public void getCreateAuction(@RequestBody CreateAuctionRequest request) {

        CustomerModel customer = customerService.getCustomerById(request.getAuctionCustomerOwnerId());
        AuctionItemModel auctionItem = auctionItemService.getAuctionItemById(request.getAuctionItemModelId());
        AuctionModel auction = AuctionModel.builder()
                .auctionCustomerOwnerId(customer)
                .auctionMinimumBid(request.getAuctionMinimumBid())
                .auctionPostDate(request.getAuctionPostDate())
                .auctionEndDate(request.getAuctionEndDate())
                .auctionBids(request.getAuctionBids())
                .auctionItemModel(auctionItem)
                .auctionCustomerList(request.getAuctionCustomerList())
                .build();
        auctionService.createAuction(auction);
    }

    @PostMapping
    public void EditAuctionWithBid(@RequestBody EditAuctionWithBidRequest request) {

        CustomerModel customer = customerService.getCustomerById(request.getCustomerModelId());
        AuctionModel auction = auctionService.getAuctionById(request.getAuctionModelId());
        BidModel bid = BidModel.builder()
                .bidAmount(request.getBidAmount())
                .bidDate(request.getBidDate())
                .auctionModelId(auction)
                .customerModelId(customer)
                .build();
        bidService.createBid(bid);
    }


//    public void getEditAuction() {
//
//    }
//
//    public void postEditAuction() {
//
//    }

    @PostMapping
    public void deleteAuction(@PathVariable("id") Long auctionId) {
        auctionService.deleteAuction(auctionId);
//        return;?
    }

}
