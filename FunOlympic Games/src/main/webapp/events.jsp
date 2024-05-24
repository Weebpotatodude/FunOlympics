<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <li><a href="showEventsServlet">Events</a></li>
                    <li><a href="ViewThreadsServlet">Forum</a></li>
                    <li><a href="logoutServlet">Logout</a></li>
                </ul>
            </nav>
        </div>
    </header>

<main>
    <section id="events">
        <div class="container">
            <h2>Events</h2>

            <!-- Notification Message -->
            <c:if test="${not empty sessionScope.message}">
                <div class="${sessionScope.messageType}">
                    ${sessionScope.message}
                </div>
                <c:remove var="message" scope="session"/>
                <c:remove var="messageType" scope="session"/>
            </c:if>

            <div id="event-list" class="event-columns">
                <c:forEach var="event" items="${eventList}">
                    <div class="event">
                        <h3>${event.eventName}</h3>
                        <p>${event.eventDate}</p>
                        <p>${event.eventDescription}</p>
                        <c:if test="${not empty event.eventImage}">
                            <img src="${event.eventImage}" alt="${event.eventName}">
                        </c:if>
                        <form action="InterestServlet" method="post">
                            <input type="hidden" name="eventId" value="${event.id}">
                            <button type="submit">Mark as Interested</button>
                        </form>
                    </div>
                </c:forEach>
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
