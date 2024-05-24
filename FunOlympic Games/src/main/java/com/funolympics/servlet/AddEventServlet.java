package com.funolympics.servlet;

import com.funolympics.dao.EventDAO;
import com.funolympics.model.Event;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;

@WebServlet("/addEventServlet")
@MultipartConfig
public class AddEventServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eventName = request.getParameter("eventName");
        String eventDate = request.getParameter("eventDate");
        String eventTime = request.getParameter("eventTime");
        String eventLocation = request.getParameter("eventLocation");
        String eventDescription = request.getParameter("eventDescription");
        Part eventImagePart = request.getPart("eventImage");

        String fileName = Paths.get(eventImagePart.getSubmittedFileName()).getFileName().toString();
        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        String filePath = "uploads" + File.separator + fileName;
        eventImagePart.write(uploadPath + File.separator + fileName);

        Event event = new Event();
        event.setEventName(eventName);
        event.setEventDate(eventDate);
        event.setEventTime(eventTime);
        event.setEventLocation(eventLocation);
        event.setEventDescription(eventDescription);
        event.setEventImage(filePath);

        EventDAO eventDAO = new EventDAO();
        try {
            eventDAO.addEvent(event);
            response.sendRedirect("ManageEventsServlet");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database error when adding event", e);
        }
    }
}
