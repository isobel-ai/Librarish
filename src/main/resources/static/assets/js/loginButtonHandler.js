const loginForm = document.getElementById("loginForm");
const nameInput = document.getElementById("name");
const passwordInput = document.getElementById("password");
const loginButton = document.getElementById("loginButton");
const errorMessage = document.getElementById("errorMessage");

loginForm.addEventListener("input", () => {
    loginButton.disabled = nameInput.value === "" || passwordInput.value === "";
    errorMessage.textContent = "";
});
