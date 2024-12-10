package org.barkancanerdogdu.breakcodeengine.config;

import org.barkancanerdogdu.breakcodeengine.entities.User;

import org.barkancanerdogdu.breakcodeengine.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserService userService;

    public DataLoader(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("password");

        User user1 = new User();
        user1.setUsername("user1");
        user1.setPassword("pass123");

        User user2 = new User();
        user2.setUsername("user2");
        user2.setPassword("welcome");

        userService.save(admin);
        userService.save(user1);
        userService.save(user2);
    }
}
