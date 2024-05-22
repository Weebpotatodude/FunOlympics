<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - FunOlympics 2024</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <section id="login">
        <div class="container">
            <h2>Login</h2>
            <form action="LoginServlet" method="post">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
                <br>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
                <br>
                <input type="submit" value="Login">
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
