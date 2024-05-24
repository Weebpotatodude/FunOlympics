package com.funolympics.servlet;

import com.funolympics.dao.ThreadDAO;
import com.funolympics.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addThreadServlet")
public class AddThreadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            String title = request.getParameter("title");
            String content = request.getParameter("content");

            ThreadDAO threadDAO = new ThreadDAO();
            try {
                threadDAO.addThread(user.getId(), title, content);
                session.setAttribute("message", "Thread successfully created.");
                session.setAttribute("messageType", "success");
            } catch (SQLException e) {
                e.printStackTrace();
                session.setAttribute("message", "Failed to create thread.");
                session.setAttribute("messageType", "error");
            }
        } else {
            session.setAttribute("message", "You must be logged in to create a thread.");
            session.setAttribute("messageType", "error");
        }
        response.sendRedirect("viewThreadsServlet");
    }
}
