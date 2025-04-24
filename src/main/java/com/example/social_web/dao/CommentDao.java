package com.example.social_web.dao;

import com.example.social_web.model.Comment;
import com.example.social_web.model.Post;

import java.util.List;

public interface CommentDao {

    List<Comment> getComment();
    boolean createComment(Comment cmt);

}