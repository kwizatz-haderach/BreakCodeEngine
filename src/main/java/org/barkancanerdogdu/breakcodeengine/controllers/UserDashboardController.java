package org.barkancanerdogdu.breakcodeengine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class UserDashboardController {

    @GetMapping
    public String showDashboard() {
        return "dashboard";
    }

}
