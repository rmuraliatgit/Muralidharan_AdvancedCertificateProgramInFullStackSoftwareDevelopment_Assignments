function login() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    // You can add your own validation logic here
    if (username === "admin@admin.com" && password === "Admin@321") {
        // Redirect to your resume page
        window.location.href = "../HTML/resume.html";
    } else {
        alert("Invalid username or password!");
    }
}