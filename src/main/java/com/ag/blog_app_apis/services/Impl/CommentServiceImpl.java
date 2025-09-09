package com.ag.blog_app_apis.services.Impl;

import com.ag.blog_app_apis.entities.Comment;
import com.ag.blog_app_apis.entities.Post;
import com.ag.blog_app_apis.exceptions.ResourceNotFoundException;
import com.ag.blog_app_apis.payloads.CommentDTO;
import com.ag.blog_app_apis.repositories.CommentRepo;
import com.ag.blog_app_apis.repositories.PostRepo;
import com.ag.blog_app_apis.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CommentDTO createComment(CommentDTO commentDTO, Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "postId", postId));
        Comment comment = this.modelMapper.map(commentDTO, Comment.class);
        comment.setPost(post);
        Comment savedComment = this.commentRepo.save(comment);
        return this.modelMapper.map(savedComment, CommentDTO.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
    Comment comment = this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "commentId", commentId));
    this.commentRepo.delete(comment);
    }
}
