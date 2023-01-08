package com.notimplement.happygear.model.mapper;

import com.notimplement.happygear.entities.Comment;
import com.notimplement.happygear.model.dto.CommentDto;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public static CommentDto toCommentDto(Comment comment){
        if(comment!=null){
            CommentDto dto = new CommentDto();
            dto.setCommentId(comment.getCommentId());
            dto.setContent(comment.getContent());
            dto.setUserName(comment.getCommentUser().getUsername());
            dto.setProductId(comment.getCommentProduct().getProductId());
            return dto;
        }
        return null;
    }
}
