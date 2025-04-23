package com.example.social_web.service.impl;

import com.example.social_web.dao.PostDao;
import com.example.social_web.model.Post;
import com.example.social_web.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostServiceImpl implements PostService {

    @Autowired
    PostDao postDao;

    public List<Post> getPost(){
        return postDao.getPost();
    }
    public String createPost(Post postRequest){
        return postDao.createPost(postRequest);
    }

    @Override
    public void updatePost(int id, Post post) {

    }

    @Override
    public void deletePost(int id) {

    }

}
