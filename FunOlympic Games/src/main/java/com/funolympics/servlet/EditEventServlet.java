package com.funolympics.servlet;

import com.funolympics.dao.EventDAO;
import com.funolympics.model.Event;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/editEventServlet")
public class EditEventServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int eventId = Integer.parseInt(request.getParameter("id"));
        EventDAO eventDAO = new EventDAO();
        try {
            Event event = eventDAO.getEventById(eventId);
            request.setAttribute("event", event);
            request.getRequestDispatcher("editEvent.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database error when retrieving event", e);
        }
    }
}
