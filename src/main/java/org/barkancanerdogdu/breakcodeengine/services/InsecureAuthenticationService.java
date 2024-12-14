package org.barkancanerdogdu.breakcodeengine.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.barkancanerdogdu.breakcodeengine.entities.User;
import org.springframework.stereotype.Service;

@Service
public class InsecureAuthenticationService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public User authenticate(String username, String password) {
        String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
        try {
            return (User) entityManager.createNativeQuery(query, User.class).getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException("Authentication query failed: " + e.getMessage());
        }
    }
}
