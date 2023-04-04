package com.example.auctionsite.model;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bid {

    @Id
    private Long bidId;

    private int amount;

//    private Date

}
