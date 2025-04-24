package com.example.social_web.dao.impl;

import com.example.social_web.dao.CommentDao;
import com.example.social_web.model.Comment;
import com.example.social_web.model.Post;
import com.example.social_web.rowmapper.CommentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Comment> getComment() {
        String sql = "SELECT * FROM Comments;";

        return namedParameterJdbcTemplate.query(sql, new CommentRowMapper());

    }

    @Override
    public boolean createComment(Comment cmt) {
        String sql = "INSERT INTO Comments(user_id, post_id, content) VALUES (:user_id, :post_id, :content)";

        Map<String, Object> params = new HashMap<>();

        params.put("user_id", cmt.getUserId());
        params.put("post_id", cmt.getPostId());
        params.put("content", cmt.getContent());

        int rowsAffected = namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(params) );

        if (rowsAffected > 0){
            return true;
        }else {
            return false;
        }
    }

}
