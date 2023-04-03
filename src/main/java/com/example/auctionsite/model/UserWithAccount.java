package com.example.auctionsite.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserWithAccount {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserId;

    @OneToMany
    private List<AuctionItem> auctionItemList;

    private String nickmane;

    private String firstName;

    private String surname;


}
