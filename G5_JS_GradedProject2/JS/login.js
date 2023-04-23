function login() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    if (username === "admin@admin.com" && password === "Admin@321") {
        window.location.href = "../HTML/resume.html";
        history.pushState(null, null, null);
        window.addEventListener('popstate', function () {
            history.pushState(null, null, null);
        });
    } else {
        alert("Invalid username or password!");
    }
}
