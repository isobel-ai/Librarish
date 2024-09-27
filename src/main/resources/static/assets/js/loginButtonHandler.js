const loginForm = document.getElementById("loginForm");
const nameInput = document.getElementById("name");
const passwordInput = document.getElementById("password");
const loginButton = document.getElementById("loginButton");

loginForm.addEventListener("input", () => {
    loginButton.disabled = nameInput.value === "" || passwordInput.value === "";
});
