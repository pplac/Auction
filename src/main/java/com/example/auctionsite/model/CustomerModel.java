package com.example.auctionsite.model;


import com.example.auctionsite.annotation.PostalCode;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String customerName;

    private String customerPassword;

//    @Email(regexp = ".+[@].+[\\.].+")
//    @EmailApp
    private String customerEmail;

    @PostalCode
    private String customerPostalCode;

    @ManyToMany
    private List<AuctionModel> customerAuctionList;

    @OneToMany
    private List<AuctionItemModel> customerItemsWon;

    @OneToMany
    private Set<BidModel> customerBidsList = new HashSet<>();



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return customerName;
    }

    @Override
    public String getPassword() {
        return customerPassword;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
