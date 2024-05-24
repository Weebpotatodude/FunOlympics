<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - FunOlympics 2024</title>
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
                    <li><a href="forum.jsp">Forum</a></li>
                    <li><a href="logoutServlet">Logout</a></li>
                </ul>
            </nav>
        </div>
    </header>
    
    <section id="login">
        <div class="login-box">
            <h2>Login</h2>
            <form action="loginServlet" method="post">
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <div class="form-group">
                    <input type="submit" value="Login">
                </div>
            </form>
            <p>Don't have an account? <a href="register.jsp">Create one here</a>.</p>
        </div>
    </section>
    <footer>
        <div class="container">
            <p>&copy; 2024 FunOlympics. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>
