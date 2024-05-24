<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Management - FunOlympics 2024</title>
    <link rel="stylesheet" href="css/styles.css">
    <script src="scripts/manageUsers.js"></script>
</head>
<body>
    <section id="user-management">
        <div class="container">
            <div class="header">
                <h2>User Management</h2>
                <div class="actions">
                    <input type="text" id="searchInput" placeholder="Search users..." onkeyup="filterUsers()">
                    <button onclick="location.href='addUser.jsp'">Add User</button>
                </div>
            </div>
            <table border="1" id="userTable">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>Country</th>
                        <th>Contact Number</th>
                        <th>Role</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${userList}">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.username}</td>
                            <td>${user.email}</td>
                            <td>${user.country}</td>
                            <td>${user.contactNumber}</td>
                            <td>${user.role}</td>
                            <td>
                                <button onclick="editUser(${user.id})">Edit</button>
                                <button onclick="deleteUser(${user.id})">Delete</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </section>
</body>
</html>
