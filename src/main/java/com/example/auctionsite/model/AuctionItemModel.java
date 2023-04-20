package com.example.auctionsite.model;


import com.example.auctionsite.model.enums.Categories;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AuctionItemModel {

    @Id
    private Long auctionItemId;

    private String auctionItemTitle;

    private Categories auctionItemCategory;

    @Column(name = "description")
    private String auctionItemDescription;

    private BigDecimal auctionItemInitCost;

    @OneToOne
    private AuctionModel auctionModel;

    @ManyToOne
    private CustomerModel auctionItemOwnerCustomer;

}
