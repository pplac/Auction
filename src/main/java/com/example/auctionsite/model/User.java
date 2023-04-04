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
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @OneToMany
    private List<Auction> auctionItemList;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

}
