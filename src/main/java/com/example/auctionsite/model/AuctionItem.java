package com.example.auctionsite.model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuctionItem {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auctionItemId;


    @ManyToOne
    private UserWithAccount userWithAccount;

    private String name;

    private Categories categories;

    private Date postDate;

    private Date experienceDate;


}
