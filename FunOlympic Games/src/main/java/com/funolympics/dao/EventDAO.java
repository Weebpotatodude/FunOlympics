package com.funolympics.dao;

import com.funolympics.model.Event;
import com.funolympics.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {
    public void addEvent(Event event) throws SQLException {
        String sql = "INSERT INTO events (event_name, event_date, event_time, event_location, event_description, event_image) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, event.getEventName());
            stmt.setString(2, event.getEventDate());
            stmt.setString(3, event.getEventTime());
            stmt.setString(4, event.getEventLocation());
            stmt.setString(5, event.getEventDescription());
            stmt.setString(6, event.getEventImage());
            stmt.executeUpdate();
        }
    }

    public List<Event> getAllEvents() throws SQLException {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM events";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Event event = new Event();
                event.setId(rs.getInt("event_id"));
                event.setEventName(rs.getString("event_name"));
                event.setEventDate(rs.getString("event_date"));
                event.setEventTime(rs.getString("event_time"));
                event.setEventLocation(rs.getString("event_location"));
                event.setEventDescription(rs.getString("event_description"));
                event.setEventImage(rs.getString("event_image"));
                events.add(event);
            }
        }
        return events;
    }


public Event getEventById(int eventId) throws SQLException {
    Event event = null;
    String sql = "SELECT * FROM events WHERE id = ?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, eventId);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                event = new Event();
                event.setId(rs.getInt("event_id"));
                event.setEventName(rs.getString("event_name"));
                event.setEventDate(rs.getString("event_date"));
                event.setEventTime(rs.getString("event_time"));
                event.setEventLocation(rs.getString("event_location"));
                event.setEventDescription(rs.getString("event_description"));
                event.setEventImage(rs.getString("event_image"));
            }
        }
    }
    return event;
}


/* Delete Event */
public void deleteEvent(int event_Id) throws SQLException {
    String sql = "DELETE FROM events WHERE event_id = ?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, event_Id);
        stmt.executeUpdate();
    }
}

}