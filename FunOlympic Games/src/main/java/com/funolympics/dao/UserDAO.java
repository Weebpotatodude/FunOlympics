package com.funolympics.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.nio.charset.StandardCharsets;
import java.math.BigInteger;

import com.funolympics.model.User;
import com.funolympics.util.DBConnection;


public class UserDAO {


public static boolean registerUser(User user) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
        connection = DBConnection.getConnection();
        if (connection == null) {
            throw new SQLException("Failed to establish connection.");
        }

        String salt = generateSalt();
        String hashedPassword = hashPassword(user.getPassword(), salt);

        String query = "INSERT INTO users (username, country, email, contact_number, password, salt, role) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getCountry());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getContactNumber());
        preparedStatement.setString(5, hashedPassword);
        preparedStatement.setString(6, salt);
        String role = user.getRole();
        if (role == null) {
            role = "normal"; // replace "default" with your actual default role
        }
        preparedStatement.setString(7, role);
        int row = preparedStatement.executeUpdate();
        return row > 0;
    } finally {
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}


public static User loginUser(String email, String password) throws SQLException {
    User user = null;
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
            String hashedInputPassword = hashPassword(password, salt);
            if (!hashedInputPassword.equals(hashedPassword)) {
                return null; // password does not match
            }

            user = new User();
            user.setId(resultSet.getInt("user_id"));
            user.setUsername(resultSet.getString("username"));
            user.setCountry(resultSet.getString("country"));
            user.setEmail(resultSet.getString("email"));
            user.setContactNumber(resultSet.getString("contact_number"));
            user.setPassword(hashedPassword);
            user.setRole(resultSet.getString("role"));
        }
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
    return user;
}



public List<User> getAllUsers() throws SQLException {
    List<User> users = new ArrayList<>();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
        connection = DBConnection.getConnection();
        if (connection == null) {
            throw new SQLException("Failed to establish connection.");
        }

        String query = "SELECT * FROM users";
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("user_id"));
            user.setUsername(resultSet.getString("username"));
            user.setCountry(resultSet.getString("country"));
            user.setEmail(resultSet.getString("email"));
            user.setContactNumber(resultSet.getString("contact_number"));
            user.setRole(resultSet.getString("role"));
            users.add(user);
        }
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
    return users;
}



 private static String generateSalt() {
     SecureRandom random = new SecureRandom();
     byte[] salt = new byte[16];
     random.nextBytes(salt);
     return new BigInteger(1, salt).toString(16); // convert to hex string
 }

 private static String hashPassword(String password, String salt) {
     try {
         MessageDigest md = MessageDigest.getInstance("SHA-256");
         md.update(salt.getBytes(StandardCharsets.UTF_8)); // add salt to digest
         byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
         BigInteger number = new BigInteger(1, hashedPassword);
         StringBuilder hexString = new StringBuilder(number.toString(16));
         while (hexString.length() < 32) {
             hexString.insert(0, '0');
         }
         return hexString.toString();
     } catch (NoSuchAlgorithmException e) {
         throw new RuntimeException(e);
     }
 }
}
