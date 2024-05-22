<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Interaction - FunOlympics 2024</title>
    <link rel="stylesheet" href="css/styles.css"> <!-- Link to your existing CSS file -->
</head>
<body>
    <h2>User Activity</h2>
    <table>
        <thead>
            <tr>
                <th>Username</th>
                <th>Action</th>
                <th>Timestamp</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="activity" items="${activities}">
                <tr>
                    <td>${activity.username}</td>
                    <td>${activity.action}</td>
                    <td>${activity.timestamp}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
