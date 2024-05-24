package com.funolympics.servlet;

import com.funolympics.dao.EventDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteEventServlet")
public class DeleteEventServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int eventId = Integer.parseInt(request.getParameter("id"));
        EventDAO eventDAO = new EventDAO();
        try {
            eventDAO.deleteEvent(eventId);
            response.sendRedirect("ManageEventsServlet");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database error when deleting event", e);
        }
    }
}
