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
                    <li><a href="contact.jsp">Contact</a></li>
                    <li><a href="profile.jsp" class="active">Profile</a></li>
                    <li><a href="logout.jsp">Logout</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <main id="profile">
        <div class="container">
            <h2>User Profile</h2>
            <form action="update_profile.php" method="post">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" value="John Doe" required>
                
                <label for="country">Country:</label>
                <input type="text" id="country" name="country" value="USA" required>
                
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="john.doe@example.com" required>
                
                <label for="contact">Contact Number:</label>
                <input type="text" id="contact" name="contact" value="+1234567890" required>
                
                <label for="interests">Interested Sports:</label>
                <input type="text" id="interests" name="interests" value="Basketball, Swimming" required>
                
                <input type="submit" value="Update Profile">
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
