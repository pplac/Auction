package com.example.auctionsite.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuctionItemModel {

    @Id
    private Long auctionItemId;

    private String auctionItemTitle;

    private Categories auctionItemCategory;

    private double auctionItemStartingPrice;

    @OneToOne
    private AuctionModel auctionModel;

    @ManyToOne
    private CustomerModel auctionItemCustomer;

}
