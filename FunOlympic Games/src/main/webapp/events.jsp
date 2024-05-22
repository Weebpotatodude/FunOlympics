
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FunOlympic Games Events</title>
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
    <section id="events">
        <div class="container">
            <h2>Events</h2>
            <div id="event-list" class="event-columns">
                <!-- Event list will be dynamically loaded here -->
                <div class="event">
                    <h3>[Event Title]</h3>
                    <p>[Event Date]</p>
                    <p>[Brief Event Description]</p>
                    <a href="#event">View Details</a>
                </div>
                
                <div class="event">
                    <h3>[Event Title]</h3>
                    <p>[Event Date]</p>
                    <p>[Brief Event Description]</p>
                    <a href="#event">View Details</a>
                </div>
                
                <div class="event">
                    <h3>[Event Title]</h3>
                    <p>[Event Date]</p>
                    <p>[Brief Event Description]</p>
                    <a href="#event">View Details</a>
                </div>
                
                <div class="event">
                    <h3>[Event Title]</h3>
                    <p>[Event Date]</p>
                    <p>[Brief Event Description]</p>
                    <a href="#event">View Details</a>
                </div>
                <!-- Repeat the above div for each event -->
            </div>
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
