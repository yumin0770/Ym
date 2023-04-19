const count = document.querySelector('#count');
const content = document.querySelector('#content');

content.addEventListener('keyup',()=>{

    count.innerText = content.value.length

    if(content.value.length >= 100){
        content.classList.add('error')
    }else{
        content.classList.remove('error')
    }

});