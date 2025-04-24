package com.example.social_web.dao.impl;

import com.example.social_web.dao.PostDao;
import com.example.social_web.model.Post;
import com.example.social_web.rowmapper.PostRowMapper;
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
        String sql = "SELECT * FROM Posts";

        return namedParameterJdbcTemplate.query(sql, new PostRowMapper());
        /* alternative to rowmapper class
        return namedParameterJdbcTemplate.query(sql, (rs, rowNum) -> {
        Post post = new Post();
        post.setPostId(rs.getInt("post_id"));
        post.setUserId(rs.getInt("user_id"));
        post.setContent(rs.getString("content"));
        post.setImage(rs.getString("image"));
        post.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        return post;
    });*/
    }

    @Override
    public Post getPostById(Integer id) {
        String sql = "SELECT * FROM Posts WHERE post_id = :post_id ";
        Map<String, Object> params = new HashMap<>();
        params.put("post_id", id);

        List<Post> res = namedParameterJdbcTemplate.query(sql, params, new PostRowMapper());

        if (res.isEmpty()) {
            return null;
        } else {
            return res.get(0);
        }
        /* alternative to rowmapper class
        return namedParameterJdbcTemplate.query(sql, (rs, rowNum) -> {
        Post post = new Post();
        post.setPostId(rs.getInt("post_id"));
        post.setUserId(rs.getInt("user_id"));
        post.setContent(rs.getString("content"));
        post.setImage(rs.getString("image"));
        post.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        return post;
    });*/
    }

    public boolean createPost(Post postRequest){
        String sql = "INSERT INTO Posts (user_id, content, image) " +
                "VALUES (:userId, :content, :image)";

        Map<String, Object> params = new HashMap<>();
        params.put("userId", postRequest.getUserId());
        params.put("content", postRequest.getContent());
        params.put("image", postRequest.getImage());// 可以為 null

        int rowsAffected = namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(params) );
        if (rowsAffected > 0) {
            return true; // insert 成功
        } else {
            return false;
            //throw new RuntimeException("Insert failed");
        }
    }

    @Override
    public boolean updatePost(Integer id, Post postRequest) {
        String sql = "UPDATE Posts SET content=:content, image=:image WHERE post_id=:post_id";

        Map<String, Object> params = new HashMap<>();
        params.put("content", postRequest.getContent());
        params.put("image", postRequest.getImage());
        params.put("post_id", id);

        int rowsAffected = namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(params) );
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
            //throw new RuntimeException("Insert failed");
        }
    }

    @Override
    public boolean deletePost(Integer id) {
        String sql = "DELETE FROM Posts WHERE post_id=:post_id";

        Map<String, Object> params = new HashMap<>();
        params.put("post_id", id);

        int rowsAffected = namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(params) );
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
            //throw new RuntimeException("Insert failed");
        }

    }


}
