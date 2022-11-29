package com.notimplement.happygear.repositories;

import com.notimplement.happygear.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    Comment findByCommentId(Integer id);

    @Query("SELECT c FROM Comment c where c.commentUser.userName = ?1")
    List<Comment> findAllByUserName(String username);

    void deleteByCommentId(Integer id);
}
