package com.example.social_web.rowmapper;

import com.example.social_web.model.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentRowMapper implements RowMapper {

    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Comment cmt = new Comment();
        cmt.setCommentId(rs.getInt("comment_id"));
        cmt.setUserId(rs.getString("user_id"));
        cmt.setPostId(rs.getInt("post_id"));
        cmt.setContent(rs.getString("content"));
        cmt.setCreatedAt(rs.getTimestamp("created_at"));

        return cmt;
    }
}
