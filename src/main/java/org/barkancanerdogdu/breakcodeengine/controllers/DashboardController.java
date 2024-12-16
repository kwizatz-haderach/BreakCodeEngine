package org.barkancanerdogdu.breakcodeengine.controllers;

import org.barkancanerdogdu.breakcodeengine.entities.Comment;
import org.barkancanerdogdu.breakcodeengine.services.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DashboardController {
    private final CommentService commentService;

    public DashboardController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/dashboard/comment")
    public String addComment(@RequestParam String comment) {
        commentService.saveComment(comment);
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        List<Comment> comments = commentService.getAllComments();
        model.addAttribute("comments", comments);
        return "dashboard";
    }


}
