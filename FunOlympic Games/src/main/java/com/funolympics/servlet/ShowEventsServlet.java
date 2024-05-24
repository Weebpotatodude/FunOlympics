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
import java.util.List;

@WebServlet("/showEventsServlet")
public class ShowEventsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventDAO eventDAO = new EventDAO();
        try {
            List<Event> eventList = eventDAO.getAllEvents();
            request.setAttribute("eventList", eventList);
            request.getRequestDispatcher("events.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database error when fetching events", e);
        }
    }
}
