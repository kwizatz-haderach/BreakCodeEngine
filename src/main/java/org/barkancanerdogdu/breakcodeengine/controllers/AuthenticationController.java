package org.barkancanerdogdu.breakcodeengine.controllers;

import jakarta.servlet.http.HttpSession;
import org.barkancanerdogdu.breakcodeengine.entities.User;
import org.barkancanerdogdu.breakcodeengine.services.InsecureAuthenticationService;
import org.barkancanerdogdu.breakcodeengine.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class AuthenticationController {

    private final UserService userService;
    private final InsecureAuthenticationService insecureAuthenticationService;

    public AuthenticationController(UserService userService, InsecureAuthenticationService insecureAuthenticationService) {
        this.userService = userService;
        this.insecureAuthenticationService = insecureAuthenticationService;
    }

    @GetMapping
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/auth")
    public String handleLogin(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        if (userService.validateUser(username, password)) {
            session.setAttribute("username", username);
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @PostMapping("/insecureauth")
    public String handleInsecureAuth(@RequestParam String username, String password, Model model) {
        User user = insecureAuthenticationService.authenticate(username, password);
        if (user != null) {
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
