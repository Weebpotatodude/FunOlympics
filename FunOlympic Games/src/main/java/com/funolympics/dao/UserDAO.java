package com.funolympics.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.funolympics.model.User;
import com.funolympics.util.DBConnection;
import com.funolympics.util.PasswordUtils;

public class UserDAO {

    /* User Registration */
    public static boolean registerUser(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBConnection.getConnection();
            if (connection == null) {
                throw new SQLException("Failed to establish connection.");
            }

            String salt = PasswordUtils.generateSalt();
            String hashedPassword = PasswordUtils.hashPassword(user.getPassword(), salt);

            String query = "INSERT INTO users (username, country, email, contact_number, password, salt, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getCountry());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getContactNumber());
            preparedStatement.setString(5, hashedPassword);
            preparedStatement.setString(6, salt);
            preparedStatement.setString(7, user.getRole() != null ? user.getRole() : "normal");

            int row = preparedStatement.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    /* User Login */
    public static User loginUser(String email, String password) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            if (connection == null) {
                throw new SQLException("Failed to establish connection.");
            }

            String query = "SELECT * FROM users WHERE email = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String salt = resultSet.getString("salt");
                String hashedPassword = resultSet.getString("password");

                if (PasswordUtils.verifyPassword(password, hashedPassword, salt)) {
                    User user = new User();
                    user.setId(resultSet.getInt("user_id"));
                    user.setUsername(resultSet.getString("username"));
                    user.setCountry(resultSet.getString("country"));
                    user.setEmail(resultSet.getString("email"));
                    user.setContactNumber(resultSet.getString("contact_number"));
                    user.setRole(resultSet.getString("role"));
                    return user;
                }
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    /* Get All Users */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT * FROM users";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("user_id")); // Ensure this matches the database column name
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setCountry(resultSet.getString("country"));
                user.setContactNumber(resultSet.getString("contact_number"));
                user.setRole(resultSet.getString("role"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    /* Add User */
    public boolean addUser(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBConnection.getConnection();
            if (connection == null) {
                throw new SQLException("Failed to establish connection.");
            }

            String salt = PasswordUtils.generateSalt();
            String hashedPassword = PasswordUtils.hashPassword(user.getPassword(), salt);

            String query = "INSERT INTO users (username, email, country, contact_number, password, salt, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setString(4, user.getContactNumber());
            preparedStatement.setString(5, hashedPassword);
            preparedStatement.setString(6, salt);
            preparedStatement.setString(7, user.getRole() != null ? user.getRole() : "normal");

            int row = preparedStatement.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

/* Get User By ID */
    public User getUserById(int userId) throws SQLException {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        User user = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = new User();
                    user.setId(rs.getInt("user_id"));
                    user.setUsername(rs.getString("username"));
                    user.setEmail(rs.getString("email"));
                    user.setCountry(rs.getString("country"));
                    user.setContactNumber(rs.getString("contact_number"));
                    user.setRole(rs.getString("role"));
                }
            }
        }

        return user;
    }



/* Edit User */

public void updateUser(User user) throws SQLException {
    String sql = "UPDATE users SET username=?, email=?, country=?, contact_number=?, role=? WHERE id=?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getEmail());
        stmt.setString(3, user.getCountry());
        stmt.setString(4, user.getContactNumber());
        stmt.setString(5, user.getRole());
        stmt.setInt(6, user.getId());
        stmt.executeUpdate();
    }
}


/* Delete User */
public void deleteUser(int user_id) throws SQLException {
    String sql = "DELETE FROM users WHERE user_id=?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, user_id);
        stmt.executeUpdate();
    }
}

}