package com.example.social_web.rowmapper;

import com.example.social_web.model.Post;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostRowMapper  implements RowMapper<Post> {
    @Override
    public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setPostId(rs.getInt("post_id"));
        post.setUserId(rs.getString("user_id"));
        post.setContent(rs.getString("content"));
        post.setImage(rs.getString("image"));
        post.setCreatedAt(rs.getTimestamp("created_at"));
        return post;
    }
}
