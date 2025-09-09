package com.ag.blog_app_apis.controllers;

import com.ag.blog_app_apis.entities.Comment;
import com.ag.blog_app_apis.payloads.ApiResponse;
import com.ag.blog_app_apis.payloads.CommentDTO;
import com.ag.blog_app_apis.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDTO, @PathVariable Integer postId){
        CommentDTO createComment = this.commentService.createComment(commentDTO, postId);
        return new ResponseEntity<CommentDTO>(createComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
        this.commentService.deleteComment(commentId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted successfully", true), HttpStatus.OK);
    }
}
