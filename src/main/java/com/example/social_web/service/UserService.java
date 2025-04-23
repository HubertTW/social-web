package com.example.social_web.service;

import com.example.social_web.dto.UserLogin;
import com.example.social_web.model.User;

public interface UserService {


    String createUser(User userRequest);

    Boolean checkLoginUser(UserLogin userRequest);

    //void updateBook(Integer bookId, BookRequest bookRequest);

    //void deleteBookById(Integer bookId);
}
