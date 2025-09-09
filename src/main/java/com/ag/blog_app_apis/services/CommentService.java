package com.ag.blog_app_apis.services;

import com.ag.blog_app_apis.payloads.CommentDTO;
import org.springframework.stereotype.Service;


public interface CommentService {
    CommentDTO createComment(CommentDTO commentDTO, Integer postId);
    void deleteComment(Integer commentId);
}
