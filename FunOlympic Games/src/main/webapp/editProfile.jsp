<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Password</title>
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
                <a href="user.jsp">Dashboard</a>
                <a href="editProfile.jsp">Edit Profile</a>
                <a href="editPassword.jsp" class="active">Edit Password</a>
            </div>
            
            <form action="updateProfileServlet" method="post">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" value="<c:out value='${sessionScope.user.username}'/>" required>
                
                <label for="email">Email</label>
                <input type="email" id="email" name="email" value="<c:out value='${sessionScope.user.email}'/>" required>

                <label for="country">Country</label>
                <select id="country" name="country" required>
                    <option value="USA" <c:if test="${sessionScope.user.country == 'USA'}">selected</c:if>>USA</option>
                    <option value="Canada" <c:if test="${sessionScope.user.country == 'Canada'}">selected</c:if>>Canada</option>
                    <option value="UK" <c:if test="${sessionScope.user.country == 'UK'}">selected</c:if>>UK</option>
                    <!-- Add other countries as needed -->
                </select>
                
                <label for="contactNumber">Contact Number</label>
                <input type="text" id="contactNumber" name="contactNumber" value="<c:out value='${sessionScope.user.contactNumber}'/>" required>
                
                <input type="submit" value="Update Profile">
            </form>
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
