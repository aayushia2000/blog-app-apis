package com.ag.blog_app_apis.controllers;

import com.ag.blog_app_apis.config.AppConstants;
import com.ag.blog_app_apis.entities.Post;
import com.ag.blog_app_apis.payloads.ApiResponse;
import com.ag.blog_app_apis.payloads.PostDTO;
import com.ag.blog_app_apis.payloads.PostResponse;
import com.ag.blog_app_apis.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private PostService postService;
    //create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO, @PathVariable Integer userId, @PathVariable Integer categoryId){
        PostDTO createPost = this.postService.createPost(postDTO, userId, categoryId);
        return new ResponseEntity<PostDTO>(createPost, HttpStatus.CREATED);
    }

    //get posts by userId
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDTO>> getPostByUserId(@PathVariable Integer userId){
        List<PostDTO> postByUser = this.postService.getPostByUser(userId);
        return new ResponseEntity<List<PostDTO>>(postByUser, HttpStatus.OK);
    }

    //get posts by categoryId
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDTO>> getPostByCategory(@PathVariable Integer categoryId){
        List<PostDTO> postsByCategory = this.postService.getPostsByCategory(categoryId);
        return new ResponseEntity<List<PostDTO>>(postsByCategory,HttpStatus.OK);
    }

    //get all posts
    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPosts(@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
                                                    @RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
                                                    @RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
                                                    @RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false) String sortDir){
//        List<PostDTO> allPosts = this.postService.getAllPosts(pageNumber, pageSize);
        PostResponse allPostsPostResponse = this.postService.getAllPosts(pageNumber, pageSize, sortBy, sortDir);
        return new ResponseEntity<PostResponse>(allPostsPostResponse, HttpStatus.OK);
    }

    //get post by post Id
    @GetMapping("/post/{postId}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Integer postId){
        PostDTO postById = this.postService.getPostById(postId);
        return new ResponseEntity<PostDTO>(postById, HttpStatus.OK);
    }

    //update post by post Id
    @PutMapping("/post/{postId}")
    public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO, @PathVariable Integer postId){
        PostDTO postDTO1 = this.postService.updatePost(postDTO, postId);
        return new ResponseEntity<PostDTO>(postDTO1, HttpStatus.OK);
    }
    //delete post by post Id
    @DeleteMapping("/post/{postId}")
    public ApiResponse deletePost(@PathVariable Integer postId){
        this.postService.deletePost(postId);
        return new ApiResponse("Post is successfully deleted", true);
    }

    //search Posts by title keyword
    @GetMapping("/posts/search/{keyword}")
    public ResponseEntity<List<PostDTO>> searchPosts(@PathVariable("keyword") String keyw){
        List<PostDTO> results = this.postService.getPostByTitleKeyword(keyw);
        return new ResponseEntity<List<PostDTO>>(results, HttpStatus.OK);
    }
}
