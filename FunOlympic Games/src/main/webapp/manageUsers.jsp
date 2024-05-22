
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Users</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="manage-users-container">
        <h2>Manage Users</h2>

        <!-- Table to display all users -->
        <table>
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Country</th>
                    <th>Contact Number</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <!-- This should be generated dynamically based on the users in your database -->
                <!-- Each row has an 'Edit' button that redirects to the editUser.jsp page -->
            </tbody>
        </table>

        <!-- Button to redirect to the addUsers.jsp page -->
        <button onclick="window.location.href='addUsers.jsp'">Add User</button>
    </div>
</body>
</html>
