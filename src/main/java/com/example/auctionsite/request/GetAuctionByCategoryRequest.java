package com.example.auctionsite.request;

import com.example.auctionsite.model.enums.Categories;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class GetAuctionByCategoryRequest {

    Categories auctionItemCategory;

}
