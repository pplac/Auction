package com.example.auctionsite.model;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    private BigDecimal bidAmount;

    private LocalDateTime betDate;

    @ManyToOne
    private AuctionModel auctionModel;



}
