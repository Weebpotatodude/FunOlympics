<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit User - FunOlympics 2024</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <section id="edit-user">
        <div class="container">
            <h2>Edit User</h2>
            <form action="EditUserServlet" method="post">
                <input type="hidden" name="id" value="${user.user_id}">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" value="${user.username}" required><br><br>
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="${user.email}" required><br><br>
                <label for="country">Country:</label>
                <input type="text" id="country" name="country" value="${user.country}" required><br><br>
                <label for="contactNumber">Contact Number:</label>
                <input type="text" id="contactNumber" name="contactNumber" value="${user.contact_number}" required><br><br>
                <label for="role">Role:</label>
                <select id="role" name="role">
                    <option value="normal" ${user.role == 'normal' ? 'selected' : ''}>Normal</option>
                    <option value="admin" ${user.role == 'admin' ? 'selected' : ''}>Admin</option>
                </select><br><br>
                <input type="submit" value="Update User">
            </form>
        </div>
    </section>
</body>
</html>
