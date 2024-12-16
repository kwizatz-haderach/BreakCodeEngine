package org.barkancanerdogdu.breakcodeengine.repositories;

import org.barkancanerdogdu.breakcodeengine.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
