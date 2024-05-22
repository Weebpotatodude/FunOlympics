package com.funolympics.servlet;

import com.funolympics.dao.UserActivityDAO;
import com.funolympics.model.UserActivity;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class UserInteractionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L; // Add serialVersionUID
    private UserActivityDAO activityDAO = new UserActivityDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserActivity> activities = activityDAO.getAllActivities();
        request.setAttribute("activities", activities);
        request.getRequestDispatcher("/userInteraction.jsp").forward(request, response);
    }
}
