
const h1 = document.querySelector("h1");

function clickColor(){
    h1.style.color='blue';
}

function handleMouseEnter(){
    h1.innerText = "mouse is here";
}

function handleMouseLeave(){
h1.innerText = "mouse is gone";
}
function handleWindowResize(){
    document.body.style.backgroundColor ="red";
}

function handleWindowCopy(){
    alert("No Copy!")
}
function handleWindowOffline(){
    alert("SOS no wifi!");
}

function handleWindowOnline(){
    alert("All good");
}

h1.addEventListener("click",clickColor);
h1.addEventListener("mouseenter",handleMouseEnter);
h1.addEventListener("mouseleave",handleMouseLeave);

window.addEventListener("resize", handleWindowResize);
window.addEventListener("copy", handleWindowCopy);
window.addEventListener("offline", handleWindowOffline);
window.addEventListener("online", handleWindowOnline);