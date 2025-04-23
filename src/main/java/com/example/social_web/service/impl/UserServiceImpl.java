package com.example.social_web.service.impl;

import com.example.social_web.dao.UserDao;
import com.example.social_web.dto.UserLogin;
import com.example.social_web.model.User;
import com.example.social_web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl  implements UserService{

    @Autowired
    UserDao userDao;

    public String createUser(User userRequest){
       return  userDao.createUser(userRequest);
    }

    public Boolean checkLoginUser(UserLogin userRequest){
        return  userDao.checkUser(userRequest);
    }

}
