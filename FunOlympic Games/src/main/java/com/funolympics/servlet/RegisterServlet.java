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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String contactNumber = request.getParameter("contactNumber");
        String password = request.getParameter("password");

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setCountry(country);
        newUser.setContactNumber(contactNumber);
        newUser.setPassword(password);
        
        boolean isRegistered = false;
        try {
            isRegistered = UserDAO.registerUser(newUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (isRegistered) {
            HttpSession session = request.getSession();
            session.setAttribute("user", newUser); // Set the user in the session
            response.sendRedirect("user.jsp"); // Redirect to user.jsp after successful registration
        } else {
            request.setAttribute("errorMessage", "Registration failed, please try again.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
