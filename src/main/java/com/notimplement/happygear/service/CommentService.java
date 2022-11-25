package com.notimplement.happygear.service;

import com.notimplement.happygear.model.dto.CommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> getAllCommentDto();

    CommentDto getCommentById(Integer id);

    CommentDto createComment(CommentDto commentDto);

    CommentDto updateComment(CommentDto commentDto, Integer id);

    CommentDto deleteComment(Integer id);

    List<CommentDto> getAllCommentByUserName(String username);

}
