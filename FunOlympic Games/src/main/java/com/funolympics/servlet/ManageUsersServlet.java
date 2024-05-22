package com.funolympics.servlet;


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.funolympics.dao.UserDAO;
import com.funolympics.model.User;

public class ManageUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private UserDAO userDao;

    public void init() {
        userDao = new UserDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<User> users = userDao.getAllUsers();
            request.setAttribute("users", users);
            RequestDispatcher dispatcher = request.getRequestDispatcher("manageUsers.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
