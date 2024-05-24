<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Event - FunOlympics 2024</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <section id="edit-event">
        <div class="container">
            <h2>Edit Event</h2>
            <form action="UpdateEventServlet" method="post" enctype="multipart/form-data">
                <input type="hidden" name="id" value="${event.id}">
                <label for="eventName">Event Name:</label>
                <input type="text" id="eventName" name="eventName" value="${event.eventName}" required><br><br>
                <label for="eventDate">Event Date:</label>
                <input type="date" id="eventDate" name="eventDate" value="${event.eventDate}" required><br><br>
                <label for="eventTime">Event Time:</label>
                <input type="time" id="eventTime" name="eventTime" value="${event.eventTime}" required><br><br>
                <label for="eventLocation">Event Location:</label>
                <input type="text" id="eventLocation" name="eventLocation" value="${event.eventLocation}" required><br><br>
                <label for="eventDescription">Event Description:</label>
                <textarea id="eventDescription" name="eventDescription" required>${event.eventDescription}</textarea><br><br>
                <label for="eventImage">Event Image:</label>
                <input type="file" id="eventImage" name="eventImage" accept="image/*"><br><br>
                <input type="submit" value="Update Event">
            </form>
        </div>
    </section>
</body>
</html>
