<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Event - FunOlympics 2024</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <section id="add-event">
        <div class="container">
            <h2>Add Event</h2>
            <form action="AddEventServlet" method="post" enctype="multipart/form-data">
                <label for="eventName">Event Name:</label>
                <input type="text" id="eventName" name="eventName" required><br><br>
                <label for="eventDate">Event Date:</label>
                <input type="date" id="eventDate" name="eventDate" required><br><br>
                <label for="eventTime">Event Time:</label>
                <input type="time" id="eventTime" name="eventTime" required><br><br>
                <label for="eventLocation">Event Location:</label>
                <input type="text" id="eventLocation" name="eventLocation" required><br><br>
                <label for="eventDescription">Event Description:</label>
                <textarea id="eventDescription" name="eventDescription" required></textarea><br><br>
                <label for="eventImage">Event Image:</label>
                <input type="file" id="eventImage" name="eventImage" accept="image/*" required><br><br>
                <input type="submit" value="Add Event">
            </form>
        </div>
    </section>
</body>
</html>
