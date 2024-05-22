
package com.funolympics.servlet;

import com.funolympics.dao.UserDAO;
import com.funolympics.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("username");
    String country = request.getParameter("country");
    String email = request.getParameter("email");
    String contactNumber = request.getParameter("contactNumber");
    String password = request.getParameter("password");

    User newUser = new User();
    newUser.setUsername(name);
    newUser.setCountry(country);
    newUser.setEmail(email);
    newUser.setContactNumber(contactNumber);
    newUser.setPassword(password);
    
    boolean isRegistered = false;
    try {
        isRegistered = UserDAO.registerUser(newUser);
    } catch (SQLException e) {
        e.printStackTrace();
    }

    if (isRegistered) {
        response.sendRedirect("user.jsp"); // Redirect to login page after successful registration
    } else {
        request.setAttribute("errorMessage", "Registration failed, please try again.");
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }
}
}