const size = document.querySelector('#size');
const color = document.querySelector('#color');
const btn  = document.querySelector('#apply');
const content  = document.querySelector('#content');
const regi  = document.querySelector('#registration');
const result = document.querySelector('#result')

btn.addEventListener('click',()=>{

    content.style.color = color.value;   //값 가져올 때 '' 안 붙임
    content.style.fontSize =`${size.value}px`;
});

regi.addEventListener('click',()=>{

    const p = document.createElement("p")  //p 태그를 불러와서 저장
    
    p.innerText =  content.value; //p태그 안에 content 내용을 추가

    const contentStyle =content.getAttribute('style'); //content의 style값을 가져와서 contentStyle에 저장

    p.setAttribute('style',contentStyle) //p태그에 style속성추가하고 content.style를 적용

    result.append(p); //결과에 p태그를 추가
    
   
})

