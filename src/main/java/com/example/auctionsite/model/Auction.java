package com.example.auctionsite.model;


import com.example.auctionsite.auth.Customer;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auctionId;

    private String title;

    private Categories category;

    @OneToMany
    private List<Bid> bids;

    @ManyToOne
    private Customer customer;

    private BigDecimal startPrice;

    private BigDecimal minimumBidIncrement;

    private Date postDate;

    private Date endDate;


}
