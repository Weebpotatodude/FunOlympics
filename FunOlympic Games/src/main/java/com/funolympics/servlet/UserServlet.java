package com.funolympics.servlet;

import com.funolympics.dao.InterestDAO;
import com.funolympics.model.Event;
import com.funolympics.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            InterestDAO interestDAO = new InterestDAO();
            try {
                List<Event> interestedEvents = interestDAO.getInterestedEvents(user.getId());
                request.setAttribute("interestedEvents", interestedEvents);
                request.getRequestDispatcher("user.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new ServletException("Database error when fetching interested events", e);
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
