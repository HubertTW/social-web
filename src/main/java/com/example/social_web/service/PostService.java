package com.example.social_web.service;

import com.example.social_web.model.Post;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

public interface PostService {
    List<Post> getPost();
    String createPost(Post post);
    void updatePost(int id, Post post);
    void deletePost(int id);
}
