package com.example.social_web.controller;


import com.example.social_web.model.Post;
import com.example.social_web.service.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.security.core.Authentication;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getPost() {
        List<Post> all_posts = postService.getPost();

        if (all_posts != null) {
            return ResponseEntity.status(HttpStatus.OK).body(all_posts);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody Post postRequest, HttpSession session) {
        Object userId = session.getAttribute("userId");

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("login required");
        }

        postService.createPost(postRequest);
        return ResponseEntity.ok("Post created.");
    }
    /*
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(@PathVariable int id, @RequestBody Post post) {
        Post existing = postService.findById(id);
        if (!existing.getUsername().equals(authentication.getName())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No permission");
        }
        existing.setContent(post.getContent());
        postService.save(existing);
        return ResponseEntity.ok("Updated.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable int id, Authentication authentication) {
        Post existing = postService.findById(id);
        if (!existing.getUsername().equals(authentication.getName())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No permission");
        }
        postService.delete(id);
        return ResponseEntity.ok("Deleted.");
    }
    */

}
