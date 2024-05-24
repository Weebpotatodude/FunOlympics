document.querySelectorAll('.profile-container a').forEach(link => {
    link.addEventListener('click', function(event) {
        event.preventDefault();
        var modalId = 'edit' + this.parentNode.textContent.trim().split(' ')[0] + 'Modal';
        var modal = document.getElementById(modalId);
        if (modal) {
            modal.style.display = 'block';
        }
    });
});

document.querySelectorAll('.modal .close').forEach(span => {
    span.addEventListener('click', function() {
        this.parentNode.parentNode.style.display = 'none';
    });
});

window.onclick = function(event) {
    if (event.target.classList.contains('modal')) {
        event.target.style.display = 'none';
    }
}
