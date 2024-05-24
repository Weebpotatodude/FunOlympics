package com.funolympics.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import com.funolympics.dao.UserDAO;
import com.funolympics.model.User;

@WebServlet("/editUserServlet")
public class EditUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String contactNumber = request.getParameter("contactNumber");
        String role = request.getParameter("role");
        
        User user = new User();
        user.setId(userId);
        user.setUsername(username);
        user.setEmail(email);
        user.setCountry(country);
        user.setContactNumber(contactNumber);
        user.setRole(role);
        
        UserDAO userDao = new UserDAO();
        try {
            userDao.updateUser(user);
            response.sendRedirect("ManageUsersServlet");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database error when updating user", e);
        }
    }
}
