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

    public Post getPostById(Integer id){
        return postDao.getPostById(id);
    }

    public boolean createPost(Post postRequest){
        return postDao.createPost(postRequest);
    }

    public boolean updatePost(Integer id, Post post) {
        return postDao.updatePost(id, post);
    }


    public boolean deletePost(Integer id) {
        return postDao.deletePost(id);
    }

}
