<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
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
                    <li><a href="ShowEventsServlet">Events</a></li>
                    <li><a href="viewThreadsServlet">Forum</a></li>
                    <li><a href="LogoutServlet">Logout</a></li>
                </ul>
            </nav>
        </div>
    </header>

    <main>
        <div class="profile-container">
            <div class="nav-tabs">
                <a href="dashboard.jsp" class="active">Dashboard</a>
                <a href="editProfile.jsp">Edit Profile</a>
                <a href="editPassword.jsp">Edit Password</a>
                <a href="logoutServlet">User Logout</a>
            </div>

            <h2>Welcome to your user dashboard, <c:out value="${sessionScope.user.username}"/>!</h2>
            <p>@<c:out value="${sessionScope.user.username}"/></p>
            <p>From your account dashboard you can edit your <a href="editProfile.jsp">Profile Details</a> and <a href="editPassword.jsp">Edit Your Password</a>.</p>
            <p>Not <c:out value="${sessionScope.user.username}"/>? <a href="logoutServlet">Sign Out</a></p>

            <h3>Interested Events</h3>
            <c:if test="${empty sessionScope.interestedEvents}">
                <p>You have no interested events.</p>
            </c:if>
            <c:if test="${not empty sessionScope.interestedEvents}">
                <div class="events">
                    <c:forEach var="event" items="${sessionScope.interestedEvents}">
                        <div class="event">
                            <h4>${event.eventName}</h4>
                            <p>${event.eventDate}</p>
                            <p>${event.eventDescription}</p>
                            <c:if test="${not empty event.eventImage}">
                                <img src="${event.eventImage}" alt="${event.eventName}">
                            </c:if>
                        </div>
                    </c:forEach>
                </div>
            </c:if>
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
