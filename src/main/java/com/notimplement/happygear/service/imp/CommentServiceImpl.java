package com.notimplement.happygear.service.imp;

import com.notimplement.happygear.entities.Comment;
import com.notimplement.happygear.model.dto.CommentDto;
import com.notimplement.happygear.model.mapper.CommentMapper;
import com.notimplement.happygear.repositories.CommentRepository;
import com.notimplement.happygear.repositories.ProductRepository;
import com.notimplement.happygear.repositories.UserRepository;
import com.notimplement.happygear.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<CommentDto> getAllCommentDto() {
        return commentRepository.findAll().stream().map(CommentMapper::toCommentDto).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(Integer id) {
        return CommentMapper.toCommentDto(commentRepository.findByCommentId(id));
    }

    @Override
    public CommentDto createComment(CommentDto commentDto) {
        Comment newComment = toComment(commentDto);
        if(newComment!=null){
            commentRepository.save(newComment);
            return CommentMapper.toCommentDto(newComment);
        }
        return null;
    }

    @Override
    public CommentDto updateComment(CommentDto commentDto, Integer id) {
        CommentDto updateComment = getCommentById(id);
        if(updateComment!=null){
            updateComment.setCommentId(id);
            updateComment.setContent(commentDto.getContent());
            updateComment.setUserName(commentDto.getUserName());
            updateComment.setProductId(commentDto.getProductId());
            commentRepository.save(toComment(updateComment));
            return updateComment;
        }
        return null;
    }

    @Override
    public CommentDto deleteComment(Integer id) {
        CommentDto updateComment = getCommentById(id);
        if(updateComment!=null){
            commentRepository.save(toComment(updateComment));
            return updateComment;
        }
        return null;
    }

//    @Override
//    public List<CommentDto> getAllCommentByUserName(String username) {
//        return commentRepository.findAllByCommentUser(username)
//                .stream().map(CommentMapper::toCommentDto).collect(Collectors.toList());
//    }

    private Comment toComment(CommentDto commentDto){
        if(commentDto!=null){
            Comment comment = new Comment();
            comment.setCommentId(comment.getCommentId());
            comment.setContent(commentDto.getContent());
            comment.setCommentUser(userRepository.findByUserName(commentDto.getUserName()));
            comment.setCommentProduct(productRepository.findByProductId(commentDto.getProductId()));
            return comment;
        }
        return null;
    }
}
