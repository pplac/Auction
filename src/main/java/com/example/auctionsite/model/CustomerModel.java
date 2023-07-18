package com.example.auctionsite.model;


import com.example.auctionsite.annotation.EmailApp;
import com.example.auctionsite.annotation.PostalCode;
import com.example.auctionsite.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CustomerModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String customerName;

    private String customerPassword;

    @EmailApp
    private String customerEmail;

    @PostalCode
    private String customerPostalCode;

    @JsonIgnore
    @OneToMany
    private List<AuctionModel> customerAuctionOwnerList;

    //    @JsonIgnore
    @ManyToMany
    @JsonIgnore
//    @JoinTable(name = "customerModel_auctionModel",
//            joinColumns = { @JoinColumn(name = "customerModel_customerId") },
//            inverseJoinColumns = { @JoinColumn(name = "auctionModel_auctionId") })
    private List<AuctionModel> customerAuctionList;

    @OneToMany
    @JsonIgnore
    private Set<BidModel> customerBids;

    @JsonIgnore
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    Set<Role> customerRoles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(customerRoles.toString());
        return Collections.singleton(authority);
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
