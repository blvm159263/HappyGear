package com.notimplement.happygear.repositories;

import com.notimplement.happygear.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Comment findByCommentId(Integer id);

    //List<Comment> findAllByUserName(String username);

    Comment deleteByCommentId(Integer id);
}
