package com.funolympics.dao;

import com.funolympics.model.UserActivity;
import com.funolympics.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserActivityDAO {
    public List<UserActivity> getAllActivities() {
        List<UserActivity> activities = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT username, action, timestamp FROM user_activities";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UserActivity activity = new UserActivity();
                activity.setUsername(resultSet.getString("username"));
                activity.setAction(resultSet.getString("action"));
                activity.setTimestamp(resultSet.getTimestamp("timestamp"));
                activities.add(activity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return activities;
    }
}
