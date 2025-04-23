package com.example.social_web.dto;

public class PostRequest {

    private int postId;
    private int userId;
    private String content;
    private String image;         // 可為 null，表示沒有圖片
    private String createdAt;     // 若要精確控制可改為 java.sql.Timestamp

    // Getters and Setters
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    // Optional: toString for debugging
    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
