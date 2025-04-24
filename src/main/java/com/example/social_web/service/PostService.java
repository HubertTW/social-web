package com.example.social_web.service;

import com.example.social_web.model.Post;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

public interface PostService {
    List<Post> getPost();
    Post getPostById(Integer id);
    boolean createPost(Post post);
    boolean updatePost(Integer id, Post post);
    boolean deletePost(Integer id);
}
