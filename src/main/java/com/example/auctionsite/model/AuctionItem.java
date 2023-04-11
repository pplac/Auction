package com.example.auctionsite.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class AuctionItem {

    @Id
    private Long auctionItemId;

    private String title;

    private Categories category;

}
