const btn = document.querySelector('button')
const h1 = document.querySelector('h1')

/* btn.addEventListener('click', ()=>{
    
   const r = Math.floor(Math.random()*256); //랜덤 숫자 256개를 만듦
   const g = Math.floor(Math.random()*256); //랜덤 숫자 256개를 만듦
   const b = Math.floor(Math.random()*256); //랜덤 숫자 256개를 만듦
    const newColor = `rgb(${r}, ${g}, ${b})` ;//랜덤 숫자가 들어갈 const에 저장
    document.body.style.backgroundColor = newColor; //바디 백그라운드에 랜덤 숫자 들어간거 대입
    h1.innerText = newColor;
    
});
 */
btn.addEventListener('click', ()=>{
    
    const newColor = makeRandomColor();
     document.body.style.backgroundColor = newColor; //바디 백그라운드에 랜덤 숫자 들어간거 대입
     h1.innerText = newColor;
     
 });
const makeRandomColor =  ()=>{
    const r = Math.floor(Math.random()*256); 
    const g = Math.floor(Math.random()*256); 
    const b = Math.floor(Math.random()*256); 
    return `rgb(${r}, ${g}, ${b})` ;
};