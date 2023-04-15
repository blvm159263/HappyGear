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

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        List<CommentDto> res = new ArrayList<>();
        List<CommentDto> list = commentRepository.findAll()
                .stream().map(CommentMapper::toCommentDto).collect(Collectors.toList());
        list.forEach(c -> {
            if (c.getCommentParentId() == null) {
                c.setReplies(getAllChildCommentByParentComment(c.getCommentId()));
            }
        });
        list.forEach(c -> {
            if (c.getCommentParentId() == null) res.add(c);
        });
        return res;
    }

    @Override
    public List<CommentDto> getCommentByProductId(Integer id) {
        List<CommentDto> res = new ArrayList<>();
        List<CommentDto> list = commentRepository.findAllByProductId(id)
                .stream().map(CommentMapper::toCommentDto).collect(Collectors.toList());
        list.forEach(c -> {
            CommentDto commentDto = getCommentById(c.getCommentId());
            if(commentDto.getCommentParentId() == null) {
                res.add(commentDto);
            }
        });
        return res;
    }

    @Override
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    @Override
    public CommentDto getCommentById(String id) {
        Comment comment = commentRepository.findByCommentId(id);
        if (comment == null) return null;
        CommentDto commentDto = CommentMapper.toCommentDto(comment);
        List<CommentDto> child = new ArrayList<>();
        List<CommentDto> replies = getAllChildCommentByParentComment(id);
        for(CommentDto c : replies) {
            child.add(getCommentById(c.getCommentId()));
        }
        commentDto.setReplies(child);
        return commentDto;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto) {
        if (commentDto != null) {
            Comment newComment = toComment(commentDto);
            commentRepository.save(newComment);
            return CommentMapper.toCommentDto(newComment);
        }
        return null;
    }

    @Override
    public CommentDto updateComment(CommentDto commentDto, String id) {
        Comment comment = commentRepository.findByCommentId(id);
        if (comment != null) {
            comment.setContent(commentDto.getContent());
            commentRepository.save(comment);
            return CommentMapper.toCommentDto(comment);
        }
        return null;
    }

    @Override
    public CommentDto deleteComment(String id) {
        CommentDto deleteComment = getCommentById(id);
        if (deleteComment != null) {
            if (deleteComment.getCommentParentId() != null) {
                commentRepository.deleteById(id);
                return deleteComment;
            } else if (deleteComment.getCommentParentId() == null) {
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
    public List<CommentDto> getAllChildCommentByParentComment(String id) {
        return commentRepository.findByCommentParentId(id)
                .stream().map(CommentMapper::toCommentDto).collect(Collectors.toList());
    }

    private Comment toComment(CommentDto commentDto) {
        if (commentDto != null) {
            Comment comment = new Comment();
            comment.setCommentId(commentDto.getCommentId());
            comment.setContent(commentDto.getContent());
            comment.setCommentUser(userRepository.findByUsername(commentDto.getUserName()).orElseThrow());
            comment.setCommentProduct(productRepository.findByProductId(commentDto.getProductId()));
            return comment;
        }
        return null;
    }
}
