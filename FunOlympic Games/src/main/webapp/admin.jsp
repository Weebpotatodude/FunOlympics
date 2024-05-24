<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard - FunOlympics 2024</title>
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
                    <li><a href="LogoutServlet">Logout</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <section id="admin-dashboard">
        <div class="sidebar">
            <h2>Main Navigation</h2>
            <div class="admin-links">
                <a href="ManageUsersServlet" target="admin-content-iframe">User Management</a>
                <a href="ManageEventsServlet" target="admin-content-iframe">Broadcast Management</a>
                <a href="userInteraction.jsp" target="admin-content-iframe">User Interaction</a>
                <a href="account-recovery.jsp" target="admin-content-iframe">Feedback and Support</a>
            </div>
            <h2>Important</h2>
            <div class="admin-links">
                <a href="cookie-policy.jsp" target="admin-content-iframe">Cookie Policy</a>
                <a href="privacy-policy.jsp" target="admin-content-iframe">Privacy Policy</a>
                <a href="terms-conditions.jsp" target="admin-content-iframe">T&amp;C's</a>
            </div>
        </div>
        <div class="main-content">
            <iframe id="admin-content-iframe" name="admin-content-iframe"></iframe>
        </div>
    </section>
    <footer>
        <div class="container">
            <p>&copy; 2024 FunOlympics. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>
