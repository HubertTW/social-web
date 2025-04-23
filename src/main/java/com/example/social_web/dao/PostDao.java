package com.example.social_web.dao;

import com.example.social_web.model.Post;
import com.example.social_web.model.User;

import java.util.List;

public interface PostDao {
    List<Post> getPost();
    String createPost(Post postRequest);
    String updatePost(Post postRequest);
    String deletePost(int postId);
}
