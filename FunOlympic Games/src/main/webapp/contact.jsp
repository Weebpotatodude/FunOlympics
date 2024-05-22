<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - FunOlympics 2024</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <header>
        <div class="container">
            <div class="logo">
                <img src="logo.png" alt="FunOlympics 2024">
            </div>
            <nav>
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="about.jsp">About</a></li>
                    <li><a href="schedule.jsp">Schedule</a></li>
                    <li><a href="contact.jsp" class="active">Contact</a></li>
                    <li><a href="profile.jsp">Profile</a></li>
                    <li><a href="logout.jsp">Logout</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <main id="contact">
        <div class="container">
            <h2>Contact Us</h2>
            <form action="send_message.php" method="post">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>
                
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
                
                <label for="message">Message:</label>
                <textarea id="message" name="message" rows="5" required></textarea>
                
                <input type="submit" value="Send Message">
            </form>
        </div>
    </main>
    <footer>
        <div class="container">
            <p>&copy; 2024 FunOlympics. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>
