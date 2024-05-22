package com.funolympics.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class UserActivity {
    private String username;
    private String action;
    private LocalDateTime timestamp;

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp.toLocalDateTime();
    }
}
