package com.example.social_web.service;

import com.example.social_web.model.Comment;
import com.example.social_web.model.Post;

import java.util.List;

public interface CommentService {
    List<Comment> getComment();
    boolean createComment(Comment cmt);
}
