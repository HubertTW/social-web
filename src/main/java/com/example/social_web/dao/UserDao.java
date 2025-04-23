package com.example.social_web.dao;

import com.example.social_web.model.User;
import com.example.social_web.dto.UserLogin;

public interface UserDao {
    String createUser(User userRequest);
    Boolean checkUser(UserLogin userRequest);

}
