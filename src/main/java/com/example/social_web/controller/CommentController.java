package com.example.social_web.controller;

import com.example.social_web.model.Comment;
import com.example.social_web.service.CommentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping
    public ResponseEntity<List<Comment>> getComment() {
        List<Comment> all_comments = commentService.getComment();
        /* TODO: should fetch userName instead of userId */

        if (all_comments != null) {
            return ResponseEntity.status(HttpStatus.OK).body(all_comments);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> createComment(@PathVariable Integer id, @RequestBody Comment commentRequest, HttpSession session) {
        String userId = (String) session.getAttribute("userId");

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("login required");
        }

        commentRequest.setUserId(userId);
        commentRequest.setPostId(id);

        if (commentService.createComment(commentRequest)) {
            return ResponseEntity.ok("Comment created.");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create comment");
        }
    }


}

