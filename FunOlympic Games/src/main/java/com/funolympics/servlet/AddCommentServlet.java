package com.funolympics.servlet;

import com.funolympics.dao.CommentDAO;
import com.funolympics.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addCommentServlet")
public class AddCommentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            int threadId = Integer.parseInt(request.getParameter("threadId"));
            String content = request.getParameter("content");

            CommentDAO commentDAO = new CommentDAO();
            try {
                commentDAO.addComment(threadId, user.getId(), content);
                session.setAttribute("message", "Comment successfully added.");
                session.setAttribute("messageType", "success");
            } catch (SQLException e) {
                e.printStackTrace();
                session.setAttribute("message", "Failed to add comment.");
                session.setAttribute("messageType", "error");
            }
        } else {
            session.setAttribute("message", "You must be logged in to add a comment.");
            session.setAttribute("messageType", "error");
        }
        response.sendRedirect("viewThreadsServlet");
    }
}
