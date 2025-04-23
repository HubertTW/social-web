package com.example.social_web.dao.impl;

import com.example.social_web.dao.UserDao;
import com.example.social_web.dto.UserLogin;
import com.example.social_web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public String createUser(User userRequest){
        String sql = "INSERT INTO Users (user_id, user_name, email, password, cover_image, biography) " +
                "VALUES (:user_id, :user_name, :email, :password, :cover_image, :biography)";

        Map<String, Object> map = new HashMap<>();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        map.put("user_id", userRequest.getUserId());
        map.put("user_name", userRequest.getUserName());
        map.put("email", userRequest.getEmail());
        map.put("password", encoder.encode(userRequest.getPassword()));
        map.put("cover_image", userRequest.getCoverImage());
        map.put("biography", userRequest.getBiography());

        int rowsAffected = namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map) );
        if (rowsAffected > 0) {
            return "insert sucess"; // insert 成功
        } else {
            return "insert failed";
            //throw new RuntimeException("Insert failed");
        }

    }

    @Override
    public Boolean checkUser(UserLogin userRequest){

        String sql = "SELECT password FROM Users WHERE user_id = :userId";
        Map<String, Object> params = Map.of("userId", userRequest.getUserId());

        try {
            String storedHash = namedParameterJdbcTemplate.queryForObject(sql, params, String.class);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            return encoder.matches(userRequest.getPassword(), storedHash); // 明文 vs 雜湊
        } catch (EmptyResultDataAccessException e) {
            return false; // 使用者不存在
        }

    }

}
