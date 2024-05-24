<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Broadcast Management - FunOlympics 2024</title>
    <link rel="stylesheet" href="css/styles.css">
    <script src="scripts/eventManagement.js"></script>
</head>
<body>
    <section id="broadcast-management">
        <div class="container">
            <div class="header">
                <h2>Broadcast Management</h2>
                <div class="actions">
                    <input type="text" id="searchInput" placeholder="Search events..." onkeyup="filterEvents()">
                    <button onclick="location.href='addEvent.jsp'">Add Event</button>
                </div>
            </div>
            <table border="1" id="eventTable">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Event Name</th>
                        <th>Date</th>
                        <th>Time</th>
                        <th>Location</th>
                        <th>Description</th>
                        <th>Image</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="event" items="${eventList}">
                        <tr>
                            <td>${event.id}</td>
                            <td>${event.eventName}</td>
                            <td>${event.eventDate}</td>
                            <td>${event.eventTime}</td>
                            <td>${event.eventLocation}</td>
                            <td>${event.eventDescription}</td>
							<td><img src="uploads/${event.eventImage}" alt="${event.eventName}" width="50" height="50"></td>
                            <td>
                                <button onclick="editEvent(${event.id})">Edit</button>
                                <button onclick="deleteEvent(${event.id})">Delete</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </section>
</body>
</html>
