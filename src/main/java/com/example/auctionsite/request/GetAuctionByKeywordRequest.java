package com.example.auctionsite.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class GetAuctionByKeywordRequest {

    String keyword;
}
