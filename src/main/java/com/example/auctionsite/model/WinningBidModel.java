package com.example.auctionsite.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WinningBidModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long winningBidId;

    private LocalDateTime winningBidDate;

    @OneToOne
    private BidModel winningBid;
}
