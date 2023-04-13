const loginForm = document.querySelector("#login-form");
const loginInput = document.querySelector("#login-form input");


function onLoginSubmit(tomato){
    const username = loginInput.value;
    console.log(username);

}

loginForm.addEventListener("submit",onLoginSubmit);
