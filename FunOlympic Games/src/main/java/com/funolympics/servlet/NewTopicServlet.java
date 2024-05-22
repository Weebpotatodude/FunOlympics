package com.funolympics.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.funolympics.util.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class NewTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("new-topic-title");
        String description = request.getParameter("new-topic-description");

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO forum_posts (title, description) values (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, description);
            int row = statement.executeUpdate();
            if (row > 0) {
                response.sendRedirect("forum.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
