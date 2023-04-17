const btn = document.querySelector('#v2')

btn.onclick = function(){     //옛날 방법
    console.log("ㅋㄹㅋㄹ") 
    console.log("ㅋㄹㅋㄹ1") 
    console.log("ㅋㄹㅋㄹ2") 
}

function scream(){
    console.log("AJJJHHHHHHH")
}

btn.onmouseenter = scream;


document.querySelector('h1').onclick = () => {
    alert('you clicked the h1!')
}

const btn3 = document.querySelector('#v3')

btn3.addEventListener ("mouseup",()=>{
    console.log("이거다")
});

function twist() {
    console.log("TWIST!")
}
function shout() {
    console.log("SHOUT!")
}

const tasButton = document.querySelector('#tas');

// tasButton.onclick = twist;
// tasButton.onclick = shout;

tasButton.addEventListener('click', twist)
tasButton.addEventListener('click', shout)

tasButton.addEventListener('keydown', ()=>{
    tasButton.style.color = 'red';
});

