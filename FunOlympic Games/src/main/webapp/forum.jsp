<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FunOlympic Games Forum</title>
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
                    <li><a href="ShowEventsServlet">Events</a></li>
                    <li><a href="ViewThreadsServlet">Forum</a></li>
                    <li><a href="logoutServlet">Logout</a></li>
                </ul>
            </nav>
        </div>
    </header>

<main>
    <section id="forum">
        <div class="container">
            <h2>Forum</h2>

            <!-- Notification Message -->
            <c:if test="${not empty sessionScope.message}">
                <div class="${sessionScope.messageType}">
                    ${sessionScope.message}
                </div>
                <c:remove var="message" scope="session"/>
                <c:remove var="messageType" scope="session"/>
            </c:if>

            <!-- Add New Thread -->
            <div class="add-thread">
                <h3>Create a New Thread</h3>
                <form action="AddThreadServlet" method="post">
                    <input type="text" name="title" placeholder="Thread Title" required>
                    <textarea name="content" placeholder="Thread Content" required></textarea>
                    <button type="submit">Create Thread</button>
                </form>
            </div>

            <!-- Display Threads -->
            <div class="threads">
                <c:forEach var="thread" items="${threadList}">
                    <div class="thread">
                        <h3>${thread.title}</h3>
                        <p>${thread.content}</p>
                        <p>Posted by: ${thread.username} on ${thread.createdAt}</p>
                        
                        <!-- Display Comments for this Thread -->
                        <div class="comments">
                            <c:forEach var="comment" items="${thread.comments}">
                                <div class="comment">
                                    <p>${comment.content}</p>
                                    <p>Comment by: ${comment.username} on ${comment.createdAt}</p>
                                </div>
                            </c:forEach>
                        </div>

                        <!-- Add Comment -->
                        <div class="add-comment">
                            <form action="AddCommentServlet" method="post">
                                <input type="hidden" name="threadId" value="${thread.threadId}">
                                <textarea name="content" placeholder="Add a comment" required></textarea>
                                <button type="submit">Add Comment</button>
                            </form>
                        </div>
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
