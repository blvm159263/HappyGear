package com.notimplement.happygear.controllers;

import com.notimplement.happygear.model.dto.CommentDto;
import com.notimplement.happygear.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentApi {

    @Autowired
    private CommentService commentService;

    @GetMapping("")
    public ResponseEntity<?> getAllComment(){
        List<CommentDto> list = commentService.getAllCommentDto();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCommentById(@PathVariable String id){
        CommentDto commentDto = commentService.getCommentById(id);
        return ResponseEntity.ok(commentDto);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getCommentByProductId(@PathVariable Integer id){
        List<CommentDto> list = commentService.getCommentByProductId(id);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/user-comment/{username}")
    public ResponseEntity<?> getAllCommentOfUserName(@PathVariable(name = "username") String username){
        List<CommentDto> listComment = commentService.getAllCommentByUserName(username);
        return ResponseEntity.ok(listComment);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewComment(@RequestBody CommentDto commentDto){
        CommentDto newCommentDto = commentService.createComment(commentDto);
        return ResponseEntity.ok(newCommentDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateComment(@Valid @RequestBody CommentDto commentDto, @PathVariable String id){
        CommentDto newCommentDto = commentService.updateComment(commentDto, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCommentDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable String id){
        CommentDto deleteComment = commentService.deleteComment(id);
        return ResponseEntity.ok(deleteComment);
    }

    @GetMapping("/all-child-comment/{id}")
    public ResponseEntity<?> getAllChildComment(@PathVariable String id){
        List<CommentDto> list = commentService.getAllChildCommentByParentComment(id);
        return ResponseEntity.ok(list);
    }

}
