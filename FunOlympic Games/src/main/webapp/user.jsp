<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FunOlympic Games Dashboard</title>
    <link rel="stylesheet" href="css/styles.css">
    <script src="scripts.js" defer></script>
</head>
<body>
    <header>
        <div class="container">
            <div class="logo">
                <img src="logo.png" alt="FunOlympic Games">
            </div>
            <nav>
                <ul>
                    <li><a href="user.jsp">Profile</a></li>                
                    <li><a href="events.jsp">Events</a></li>
                    <li><a href="highlights.jsp">Highlights</a></li>
                    <li><a href="forum.jsp">Forum</a></li>
        			<li><a href="logoutServlet">Logout</a></li>
                </ul>
            </nav>
        </div>
    </header>

    <main>
        <section id="dashboard">
            <div class="container">
                <h2>Welcome, [User's Name]</h2>
                <p>Here are your personalized recommendations and upcoming events.</p>
                <div id="personalized-content">
                    <!-- Personalized content will be dynamically loaded here -->
                </div>
            </div>
        </section>

        <section id="events">
            <div class="container">
                <h2>Events</h2>
                <div id="event-list">
                    <!-- Events will be dynamically loaded here -->
                </div>
            </div>
        </section>

        <section id="schedule">
            <div class="container">
                <h2>Schedule</h2>
                <div id="schedule-list">
                    <!-- Schedule will be dynamically loaded here -->
                </div>
            </div>
        </section>

        <section id="forum">
            <div class="container">
                <h2>Forum</h2>
                <div id="forum-topics">
                    <!-- Forum topics will be dynamically loaded here -->
                </div>
            </div>
        </section>

        <section id="profile">
            <div class="container">
                <h2>Profile</h2>
                <form id="profile-form">
                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username" value="[User's Username]" disabled>
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" value="[User's Email]" required>
                    <label for="preferences">Preferences:</label>
                    <textarea id="preferences" name="preferences">[User's Preferences]</textarea>
                    <button type="submit">Update Profile</button>
                </form>
            </div>
        </section>
    </main>

    <footer>
        <div class="container">
            <p>&copy; 2024 FunOlympic Games. All rights reserved.</p>
            <nav>
                <ul>
                    <li><a href="#privacy">Privacy Policy</a></li>
                    <li><a href="#terms">Terms of Service</a></li>
                    <li><a href="#contact">Contact Us</a></li>
                </ul>
            </nav>
        </div>
    </footer>
</body>
</html>
