
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FunOlympic Games Highlights</title>
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
        <section id="highlights">
            <div class="container">
                <h2>Highlights</h2>
                <div id="highlight-list">
                    <!-- Highlight list will be dynamically loaded here -->
                    <div class="highlight">
                        <h3>[Highlight Title]</h3>
                        <p>[Highlight Date]</p>
                        <p>[Brief Highlight Description]</p>
                        <a href="#highlight">View Details</a>
                    </div>
                    <!-- Repeat the above div for each highlight -->
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
