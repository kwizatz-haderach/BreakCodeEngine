package org.barkancanerdogdu.breakcodeengine.services;

import org.barkancanerdogdu.breakcodeengine.entities.Comment;
import org.barkancanerdogdu.breakcodeengine.repositories.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment saveComment(String text) {
        Comment comment = new Comment();
        comment.setText(text);
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }
}
