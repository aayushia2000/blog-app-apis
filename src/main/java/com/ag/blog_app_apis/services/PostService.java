package com.ag.blog_app_apis.services;

import com.ag.blog_app_apis.entities.Post;
import com.ag.blog_app_apis.payloads.PostDTO;
import com.ag.blog_app_apis.payloads.PostResponse;

import java.util.List;

public interface PostService {
    //create
    PostDTO createPost(PostDTO postDTO, Integer userId, Integer categoryId);
    //update
    PostDTO updatePost(PostDTO postDTO, Integer postId);
    //delete
    void deletePost(Integer postId);
    //get all posts
//    List<PostDTO> getAllPosts(Integer pageNumber, Integer pageSize);
    PostResponse getAllPosts(Integer pageNumber, Integer pageSize);
    //get By Id
    PostDTO getPostById(Integer postId);
    //get all post by category
    List<PostDTO> getPostsByCategory(Integer categoryId);
    //get all post by user
    List<PostDTO> getPostByUser(Integer userId);
    //search post by keyword
    List<PostDTO> getPostByKeyword(String keyword);

}
