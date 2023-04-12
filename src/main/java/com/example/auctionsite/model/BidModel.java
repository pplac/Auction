package com.example.auctionsite.model;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BidModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bidId;

    private double bidAmount;

    @ManyToOne
    private AuctionModel auctionModel;

    @ManyToOne
    private CustomerModel customerModel;


}
