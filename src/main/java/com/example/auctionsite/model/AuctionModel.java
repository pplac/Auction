package com.example.auctionsite.model;


import com.example.auctionsite.model.enums.Categories;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AuctionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auctionId;
    @ManyToOne
    private CustomerModel auctionCustomerOwnerId;
    private BigDecimal auctionMinimumBid;
    private String auctionTitle;
    private Categories auctionItemCategory;
    @Column(name = "description")
    private String auctionItemDescription;
    private BigDecimal auctionItemInitCost;
    private int daysAuctionIsActive;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime auctionPostDate;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime auctionEndDate;
    @ManyToMany
    private Set<CustomerModel> auctionCustomerList;
    @OneToMany
    private Set<BidModel> auctionBids;
    private boolean auctionIsActive;

}
