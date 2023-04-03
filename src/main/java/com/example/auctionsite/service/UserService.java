package com.example.auctionsite.service;

import com.example.auctionsite.model.User;
import com.example.auctionsite.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(final User user) {

        if (isUserInvalidByNickname(user)) {
            throw new IllegalArgumentException();
        }
        return userRepository.save(user);
    }

    private boolean isUserInvalidByNickname(final User user) {
        return user.getNickmane().length() == 0;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(final Long userId) {
        return userRepository.findById(userId);
    }

}
