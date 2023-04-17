package com.example.auctionsite.service;

import com.example.auctionsite.model.WinningBidModel;
import com.example.auctionsite.repositories.WinningBidRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class WinningBidService {

    private WinningBidRepository winningBidRepository;


    public void addWinningBid(WinningBidModel winningBid) {
        winningBidRepository.save(winningBid);
    }



}
