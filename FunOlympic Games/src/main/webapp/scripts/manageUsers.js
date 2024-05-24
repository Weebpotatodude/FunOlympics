function filterUsers() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("searchInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("userTable");
    tr = table.getElementsByTagName("tr");
    for (i = 1; i < tr.length; i++) {
        tr[i].style.display = "none";
        td = tr[i].getElementsByTagName("td");
        for (var j = 0; j < td.length; j++) {
            if (td[j]) {
                txtValue = td[j].textContent || td[j].innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                    break;
                }
            }
        }
    }
}

/* Edit Users */
function editUser(userId) {
    // Redirect to edit user page with userId
    window.location.href = 'editUser.jsp?id=' + userId;
}

/* Delete Users */
function deleteUser(userId) {
    if (confirm("Are you sure you want to delete this user?")) {
        // Send request to delete user
        window.location.href = 'DeleteUserServlet?id=' + userId;
    }
}
