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
            dto.setAvatarUrl("https://t3.ftcdn.net/jpg/03/42/99/68/360_F_342996846_tHMepJOsXWwbvMpG7uiYpE68wbfQ9e4s.jpg");
            return dto;
        }
        return null;
    }
}
