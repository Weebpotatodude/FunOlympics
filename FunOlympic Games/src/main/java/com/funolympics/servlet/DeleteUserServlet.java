package com.funolympics.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import com.funolympics.dao.UserDAO;

@WebServlet("/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        UserDAO userDao = new UserDAO();
        
        try {
            userDao.deleteUser(userId);
            response.sendRedirect("ManageUsersServlet");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database error when deleting user", e);
        }
    }
}
