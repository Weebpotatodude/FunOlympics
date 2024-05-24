package com.funolympics.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.funolympics.model.Comment;
import com.funolympics.model.Thread;
import com.funolympics.util.DBConnection;

public class ThreadDAO {

    public void addThread(int userId, String title, String content) throws SQLException {
        String sql = "INSERT INTO threads (user_id, title, content) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setString(2, title);
            stmt.setString(3, content);
            stmt.executeUpdate();
        }
    }

    public List<Thread> getAllThreads() throws SQLException {
        List<Thread> threads = new ArrayList<>();
        String sql = "SELECT t.thread_id, t.title, t.content, t.created_at, u.username FROM threads t JOIN users u ON t.user_id = u.user_id ORDER BY t.created_at DESC";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Thread thread = new Thread();
                thread.setThreadId(rs.getInt("thread_id"));
                thread.setTitle(rs.getString("title"));
                thread.setContent(rs.getString("content"));
                thread.setCreatedAt(rs.getTimestamp("created_at"));
                thread.setUsername(rs.getString("username"));

                // Fetch comments for this thread
                List<Comment> comments = getCommentsByThreadId(thread.getThreadId(), conn);
                thread.setComments(comments);

                threads.add(thread);
            }
        }
        return threads;
    }

    private List<Comment> getCommentsByThreadId(int threadId, Connection conn) throws SQLException {
        List<Comment> comments = new ArrayList<>();
        String sql = "SELECT c.comment_id, c.content, c.created_at, u.username " +
                     "FROM comments c JOIN users u ON c.user_id = u.user_id " +
                     "WHERE c.thread_id = ? ORDER BY c.created_at ASC";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
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
