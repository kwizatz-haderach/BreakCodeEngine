package org.barkancanerdogdu.breakcodeengine.services;

import org.barkancanerdogdu.breakcodeengine.entities.Comment;
import org.barkancanerdogdu.breakcodeengine.repositories.CommentRepository;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    //XSS Sanitization
    /*PolicyFactory policy = new HtmlPolicyBuilder()
            .allowElements("a")
            .allowUrlProtocols("https")
            .allowAttributes("href").onElements("a")
            .requireRelNofollowOnLinks()
            .toFactory();*/

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment saveComment(String text) {
        Comment comment = new Comment();
        //XSS Sanitization
        /*comment.setText(policy.sanitize(text));*/
        comment.setText(text);
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComments() {
        //XSS Sanitization
        /*List<Comment> comments = commentRepository.findAll();
        comments.forEach(comment -> {
            comment.setText(policy.sanitize(comment.getText()));
        });*/
        return commentRepository.findAll();
    }
}
