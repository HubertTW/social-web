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
        /* TODO: should fetch userName instead of userId */

        if (all_posts != null) {
            return ResponseEntity.status(HttpStatus.OK).body(all_posts);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody Post postRequest, HttpSession session) {
        String userId = (String) session.getAttribute("userId");

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("login required");
        }
        /* userid shouldn't be from frontend */
        postRequest.setUserId(userId);

        if (postService.createPost(postRequest)) {
            return ResponseEntity.ok("Post created.");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create post");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(@PathVariable Integer id, @RequestBody Post post, HttpSession session) {
        /* TODO: for validation, should use @PreAuthorize("@postPermissionService.canEdit(#postId, principal.username)")*/
        Post existing = postService.getPostById(id);
        if (!existing.getUserId().equals(session.getAttribute("userId"))) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No permission");
        }
        if (postService.updatePost(id, post)) {
            return ResponseEntity.ok("Updated.");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update post");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Integer id, HttpSession session) {
        /* TODO: for validation, should use @PreAuthorize("@postPermissionService.canEdit(#postId, principal.username)")*/
        Post existing = postService.getPostById(id);
        if (!existing.getUserId().equals(session.getAttribute("userId"))) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No permission");
        }

        if (postService.deletePost(id)) {
            return ResponseEntity.ok("deleted.");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete post");
        }
    }


}
