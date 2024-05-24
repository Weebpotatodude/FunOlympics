<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FunOlympic Games</title>
    <link rel="stylesheet" href="css/styles.css">
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
                    <li><a href="showEventsServlet">Events</a></li>
                    <li><a href="ViewThreadsServlet">Forum</a></li>
                    <li><a href="logoutServlet">Logout</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <main id="hero">
        <div class="container">
            <h1>Welcome to FunOlympic Games</h1>
            <p>Join us in celebrating the spirit of sportsmanship and competition.</p>
            <a href="register.jsp" class="btn">Register Now</a>
            <a href="login.jsp" class="btn">Login</a>
        </div>
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
