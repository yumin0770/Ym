const makeRandColor = () => {
    const r = Math.floor(Math.random() * 255);
    const g = Math.floor(Math.random() * 255);
    const b = Math.floor(Math.random() * 255);
    return `rgb(${r}, ${g}, ${b})`;
}

const btn = document.querySelectorAll('button')

for(let button of btn){
    button.addEventListener('click',function(){  //클릭해서 변화하는 건 button.addEventListener
        button.style.backgroundColor = makeRandColor();
    });
}

const h1s = document.querySelectorAll('h1');

/* for(let h1 of h1s){
    h1.addEventListener('click',()=>{       //클릭시 ! 이벤트 발생
    h1.style.backgroundColor = makeRandColor();  //어떤 이벤트냐면 style이 바뀌는 이벤트
                                                //스타일 바꾸는 함수 대입
    });
} */



/* const h1s = document.querySelectorAll('h1'); 아래 색을 바꾸는 새함수 대입!
for(let h1 of h1s){
    h1.addEventListener('click',colorize)
}


function colorize(){                       위아래 똑같은 중복 코드를 피새 색을 바꾸는 새함수 만들기!
    this.style.color = makeRandColor();         근데 대입할 속성이 없으므로 this로 적용
    this.style.backgroundColor = makeRandColor();
} */