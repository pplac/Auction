package com.example.auctionsite.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Builder
public class BidModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bidId;

    @Column(name = "amount")
    private BigDecimal bidAmount;

    @Column(name = "post_date")
    private LocalDateTime bidDate;

    @JsonIgnoreProperties("auctionBids")
    @ManyToOne
    private AuctionModel auctionModelId;

    @ManyToOne
    private CustomerModel customerModelId;
}
