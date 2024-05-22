
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
                    <li><a href="events.jsp">Events</a></li>
                    <li><a href="highlights.jsp">Highlights</a></li>
                    <li><a href="forum.jsp">Forum</a></li>
        			<li><a href="logoutServlet">Logout</a></li>
                </ul>
            </nav>
        </div>
    </header>

<main>
    <section id="forum">
        <div class="container">
            <h2>FunOlympic Games Community</h2>
             
             <!-- Search form -->
            <form id="search-form">
                <label for="search-query">Search:</label>
                <input type="text" id="search-query" name="search-query" required>
                <button type="submit">Search</button>
            </form>
            
            <!-- New forum topic form -->
 
			<form id="new-topic-form" method="post" action="NewTopicServlet">
			    <label for="new-topic-title">Topic Title:</label>
			    <input type="text" id="new-topic-title" name="new-topic-title" required>
			
			    <label for="new-topic-description">Topic Description:</label>
			    <textarea id="new-topic-description" name="new-topic-description" required></textarea>
			
			    <button type="submit">Create Topic</button>
			</form>

            <div id="forum-topics">
                <!-- Forum topics will be dynamically loaded here -->
                <div class="forum-topic">
                    <h3>[Topic Title]</h3>
                    <p>[Brief Topic Description]</p>
                    <a href="#topic">View Discussion</a>
                </div>
                <!-- Repeat the above div for each forum topic -->
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
