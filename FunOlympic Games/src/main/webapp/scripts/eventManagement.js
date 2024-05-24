function filterEvents() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("searchInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("eventTable");
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

function editEvent(eventId) {
    // Redirect to edit event page with eventId
    window.location.href = 'editEvent.jsp?id=' + eventId;
}

function deleteEvent(eventId) {
    if (confirm("Are you sure you want to delete this event?")) {
        // Send request to delete event
        window.location.href = 'DeleteEventServlet?id=' + eventId;
    }
}
