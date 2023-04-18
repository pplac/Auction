package com.example.auctionsite.controller;

import com.example.auctionsite.request.CreateAuctionItemRequest;
import com.example.auctionsite.service.AuctionItemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuctionItemController {

    private AuctionItemService auctionItemService;

    @PostMapping
    public void getCreateAuctionItem(@RequestBody CreateAuctionItemRequest request){
        auctionItemService.createAuctionItem(request);
    }

}
