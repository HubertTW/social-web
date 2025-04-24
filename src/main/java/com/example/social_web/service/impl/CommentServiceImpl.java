package com.example.social_web.service.impl;

import com.example.social_web.dao.CommentDao;
import com.example.social_web.model.Comment;
import com.example.social_web.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao cmtDao;

    @Override
    public List<Comment> getComment() {
        return cmtDao.getComment();
    }

    @Override
    public boolean createComment(Comment cmt) {
        return cmtDao.createComment(cmt);
    }
}
