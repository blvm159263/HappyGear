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

import javax.transaction.Transactional;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<CommentDto> getAllCommentDto() {
        return commentRepository.findAll()
        		.stream().map(CommentMapper::toCommentDto).collect(Collectors.toList());
    }

    @Override
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    @Override
    public CommentDto getCommentById(Integer id) {
        return CommentMapper.toCommentDto(commentRepository.findByCommentId(id));
    }

    @Override
    public CommentDto createComment(CommentDto commentDto) {
        if(commentDto!=null) {
            Comment newComment = toComment(commentDto);
            commentRepository.save(newComment);
            return CommentMapper.toCommentDto(newComment);
        }
        return null;
    }

    @Override
    public CommentDto updateComment(CommentDto commentDto, Integer id) {
        Comment updateComment = commentRepository.findByCommentId(id);
        if(updateComment!=null){
            updateComment.setContent(commentDto.getContent());
            commentRepository.save(updateComment);
            return CommentMapper.toCommentDto(updateComment);
        }
        return null;
    }

    @Override
    public CommentDto deleteComment(Integer id) {
        CommentDto deleteComment = getCommentById(id);
        if(deleteComment!=null) {
        	if(deleteComment.getCommentParentId() != 0) {
            	commentRepository.deleteById(id);
                return deleteComment;
            }
            else if(deleteComment.getCommentParentId() == 0) {
            	commentRepository.deleteByCommentParentId(id);
            	commentRepository.deleteById(id);
            	return deleteComment;
            }
        }
        return null;
    }

    @Override
    public List<CommentDto> getAllCommentByUserName(String username) {
        return commentRepository.findAllByUserName(username)
                .stream().map(CommentMapper::toCommentDto).collect(Collectors.toList());
    }

    @Override
    public List<CommentDto> getAllChildCommentByParentComment(Integer id){
        return commentRepository.findByCommentParentId(id)
                .stream().map(CommentMapper::toCommentDto).collect(Collectors.toList());
    }

    private Comment toComment(CommentDto commentDto){
        if(commentDto!=null){
            Comment comment = new Comment();
            comment.setCommentId(commentDto.getCommentId());
            comment.setContent(commentDto.getContent());
            comment.setCommentParentId(commentDto.getCommentParentId());
            comment.setCommentUser(userRepository.findByUserName(commentDto.getUserName()));
            comment.setCommentProduct(productRepository.findByProductId(commentDto.getProductId()));
            return comment;
        }
        return null;
    }
}
