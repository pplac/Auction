package com.example.auctionsite.repositories;

import com.example.auctionsite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByFirstNameAndSurname(String firstName, String surname);

    List<User> findByNickmane(String nickname);


}
