const s = document.getElementById("count");
const l = document.getElementById("content").value;


l.addEventListener('keyup',()=>{
    
    const l = document.getElementById("content").value;

    s.innerText = l.length;
   
    
    if(l.length>100){
        s.classList.add('error');
    }else{
        s.classList.remove('error')
    }

    //요소.classList.toggle('클래스명')
    //-요소에 클래스가 없으면 추가 (true 반환)
    //-요소에 클래스가 있으면 제거 (false 반환)

});



   
    
