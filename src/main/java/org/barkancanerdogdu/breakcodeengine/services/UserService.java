package org.barkancanerdogdu.breakcodeengine.services;

import org.barkancanerdogdu.breakcodeengine.entities.User;
import org.barkancanerdogdu.breakcodeengine.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUserId(Long userId) {
        return userRepository.findById(userId);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean validateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }



    public void save(User user) {
        if (findByUsername(user.getUsername()) == null) {
            userRepository.save(user);
        } else {
            System.out.println("User already exists: " + user.getUsername());
        }
    }
}
