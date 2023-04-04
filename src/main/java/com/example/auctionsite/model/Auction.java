package com.example.auctionsite.model;


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
    private User user;

    private BigDecimal startPrice;

    private BigDecimal minimumBidIncrement;

    private Date postDate;

    private Date endDate;


}
