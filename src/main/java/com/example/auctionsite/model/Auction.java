package com.example.auctionsite.model;


import com.example.auctionsite.annotation.EmailApp;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
//@Data
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auctionId;

    @Embedded
    private AuctionItem item;

    @OneToMany
    private List<Bid> bids;

    @ManyToMany
    private List<Customer> customers;

    private BigDecimal startingPrice;

    private BigDecimal minimumBidIncrement;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date postDate;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date endDate;


}
