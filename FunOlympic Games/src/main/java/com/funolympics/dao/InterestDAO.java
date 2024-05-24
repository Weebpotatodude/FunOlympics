package com.funolympics.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.funolympics.model.Event;
import com.funolympics.util.DBConnection;

public class InterestDAO {

    public void addInterest(int userId, int eventId) throws SQLException {
        String sql = "INSERT INTO user_interests (user_id, event_id) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, eventId);
            stmt.executeUpdate();
        }
    }
    
    public List<Event> getInterestedEvents(int userId) throws SQLException {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT e.event_id, e.event_name, e.event_date, e.event_time, e.event_location, e.event_description, e.event_image "
                   + "FROM events e JOIN user_interests ui ON e.event_id = ui.event_id WHERE ui.user_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
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
}
