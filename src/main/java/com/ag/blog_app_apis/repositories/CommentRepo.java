package com.ag.blog_app_apis.repositories;

import com.ag.blog_app_apis.entities.Comment;
import com.ag.blog_app_apis.payloads.CommentDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
