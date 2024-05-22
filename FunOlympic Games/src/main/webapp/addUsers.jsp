<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Users</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="addUsersContainer">
        <h2>Manage Users</h2>

					<!-- Form to add a new user -->
					<form class="add-user-form" action="admin/add-user" method="post">
					    <label for="username">Username:</label>
					    <input type="text" id="username" name="username" required>
					
					    <label for="country">Country:</label>
					    <select id="country" name="country">
					        <!-- Add all the country options here -->
					    </select>
					
					    <label for="email">Email:</label>
					    <input type="email" id="email" name="email" required>
					
					    <label for="contactNumber">Contact Number:</label>
					    <input type="text" id="contactNumber" name="contactNumber" required>
					
					    <label for="password">Password:</label>
					    <input type="password" id="password" name="password" required>
					
						<label for="organization-role">Organization Role</label>
		                <select id="organization-role" name="organization-role">
		                    <option value="standard">Normal</option>
		                    <option value="admin">Admin</option>
		                </select>
		                
		                
					    <input type="submit" value="Add User">
					</form>            
					
					
				<div class="form-group">
    </div>
</div>	
</body>
</html>
