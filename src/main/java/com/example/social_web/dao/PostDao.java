package com.example.social_web.dao;

import com.example.social_web.model.Post;
import com.example.social_web.model.User;

import java.util.List;

public interface PostDao {
    List<Post> getPost();
    Post getPostById(Integer id);
    boolean createPost(Post postRequest);
    boolean updatePost(Integer id, Post post);
    boolean deletePost(Integer postId);

}
