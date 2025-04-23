package com.example.social_web.dao.impl;

import com.example.social_web.dao.PostDao;
import com.example.social_web.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PostDaoImpl implements PostDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Post> getPost() {
        return List.of();
    }

    public String createPost(Post postRequest){
        String sql = "INSERT INTO Posts (user_id, content, image) " +
                "VALUES (:userId, :content, :image)";

        Map<String, Object> params = new HashMap<>();
        params.put("userId", postRequest.getUserId());
        params.put("content", postRequest.getContent());
        params.put("image", postRequest.getImage());// 可以為 null

        int rowsAffected = namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(params) );
        if (rowsAffected > 0) {
            return "insert sucess"; // insert 成功
        } else {
            return "insert failed";
            //throw new RuntimeException("Insert failed");
        }
    }

    @Override
    public String updatePost(Post postRequest) {
        return "";
    }

    @Override
    public String deletePost(int postId) {
        return "";
    }


}
