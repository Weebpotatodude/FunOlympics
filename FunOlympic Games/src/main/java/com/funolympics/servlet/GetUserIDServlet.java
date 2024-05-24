package com.funolympics.servlet;

import com.funolympics.dao.UserDAO;
import com.funolympics.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/userIDServlet")
public class GetUserIDServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDAO userDAO = new UserDAO();

        // Assuming you store the user ID in session when the user logs in
        int userId = (int) session.getAttribute("userId");

        try {
            User user = userDAO.getUserById(userId);
            session.setAttribute("user", user);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while retrieving user information.");
        }

        request.getRequestDispatcher("user.jsp").forward(request, response);
    }
}
