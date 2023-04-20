package com.example.auctionsite.request;

import com.example.auctionsite.annotation.EmailApp;
import com.example.auctionsite.annotation.PostalCode;
import com.example.auctionsite.model.AuctionItemModel;
import com.example.auctionsite.model.AuctionModel;
import com.example.auctionsite.model.BidModel;
import com.example.auctionsite.model.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Getter
@Setter

@RequiredArgsConstructor
public class CreateCustomerRequest {

    String customerName;
    String customerPassword;
    String customerEmail;
    String customerPostalCode;
    List<AuctionModel> customerAuctionOwnerList;
    List<AuctionModel> customerAuctionList;
    Set<BidModel> customerBids;
    List<AuctionItemModel> customerItemsWon;
    Set<Role> customerRoles;


}
