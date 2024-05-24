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

@WebServlet("/addUsersServlet")
public class AddUsersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String contactNumber = request.getParameter("contactNumber");
        String role = request.getParameter("role");
        String password = request.getParameter("password");

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setCountry(country);
        newUser.setContactNumber(contactNumber);
        newUser.setRole(role);
        newUser.setPassword(password); // Assume password is set here for hashing

        UserDAO userDao = new UserDAO();
        try {
            boolean success = userDao.addUser(newUser);
            if (success) {
                response.sendRedirect("manageUsersServlet");
            } else {
                response.sendRedirect("errorPage.jsp"); // Redirect to an error page if needed
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database error when adding user", e);
        }
    }
}
