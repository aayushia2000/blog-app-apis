package com.ag.blog_app_apis.payloads;

import com.ag.blog_app_apis.entities.Category;
import com.ag.blog_app_apis.entities.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class PostDTO {
//    private Integer postId;
    private Integer postId;
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;

//    @ManyToOne
//    @JoinColumn(name = "category_id")
    private Category category;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
    private User user;

    public PostDTO() {
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
