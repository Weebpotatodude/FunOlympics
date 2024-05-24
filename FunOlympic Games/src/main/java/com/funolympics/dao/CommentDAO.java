package com.funolympics.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.funolympics.model.Comment;
import com.funolympics.util.DBConnection;

public class CommentDAO {

    public void addComment(int threadId, int userId, String content) throws SQLException {
        // Validate user_id
        if (!isValidUserId(userId)) {
            throw new SQLException("User ID does not exist in users table.");
        }

        String sql = "INSERT INTO comments (thread_id, user_id, content) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, threadId);
            stmt.setInt(2, userId);
            stmt.setString(3, content);
            stmt.executeUpdate();
        }
    }

    private boolean isValidUserId(int userId) throws SQLException {
        String checkUserQuery = "SELECT user_id FROM users WHERE user_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkUserQuery)) {
            checkStmt.setInt(1, userId);
            try (ResultSet rs = checkStmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    public List<Comment> getCommentsByThreadId(int threadId) throws SQLException {
        List<Comment> comments = new ArrayList<>();
        String sql = "SELECT c.comment_id, c.content, c.created_at, u.username FROM comments c JOIN users u ON c.user_id = u.user_id WHERE c.thread_id = ? ORDER BY c.created_at ASC";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, threadId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Comment comment = new Comment();
                    comment.setCommentId(rs.getInt("comment_id"));
                    comment.setContent(rs.getString("content"));
                    comment.setCreatedAt(rs.getTimestamp("created_at"));
                    comment.setUsername(rs.getString("username"));
                    comments.add(comment);
                }
            }
        }
        return comments;
    }
}
