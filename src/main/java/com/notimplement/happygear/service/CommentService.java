package com.notimplement.happygear.service;

import com.notimplement.happygear.entities.Comment;
import com.notimplement.happygear.model.dto.CommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> getAllCommentDto();

    List<Comment> getAllComment();

    CommentDto getCommentById(String id);

    CommentDto createComment(CommentDto commentDto);

    CommentDto updateComment(CommentDto commentDto, String id);

    CommentDto deleteComment(String id);

    List<CommentDto> getAllCommentByUserName(String username);

    List<CommentDto> getAllChildCommentByParentComment(String id);

    List<CommentDto> getCommentByProductId(Integer id);
}
