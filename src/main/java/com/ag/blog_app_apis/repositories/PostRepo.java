package com.ag.blog_app_apis.repositories;

import com.ag.blog_app_apis.entities.Category;
import com.ag.blog_app_apis.entities.Post;
import com.ag.blog_app_apis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
//    List<Post> findByTitleContaining(String title);
    @Query("Select p from Post p where p.title like :key")
    List<Post> searchByTitle(@Param("key") String title);
}
