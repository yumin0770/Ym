//계산 버튼 클릭 시
//input 태그에 작성된 값을 모두 읽어와 합한 결과를 alert로 출력

const calc = document.getElementById("calc");

calc.addEventListener("click",()=>{ //계산 버튼을 눌렀을 때
    const list = document.getElementsByClassName("in"); // in클래스들을 불러와서 list에 저장함

    let sum = 0;  //합계 저장용 변수선언
    
    for(i=0; i<list.length; i++){ // 리스트의 길이(클래스 수만큼 누적)
        //HTML에 작성된 모든 내용, 속성, 값은 String(문자열);
      sum += Number(list[i].value); //리스트의 인덱스, 클래스의 하나 값들의 누적
    
    }alert(sum); //합계를 alert창으로
});
//----------------------------------------------------------------------

//추가 버튼이 클릭 되었을 때
//.container 요소의 마지막 자식으로 
//<div class="row">
//        <input type="number" class="in">
//</div>
//위 요소를 만들어서 추가하기

const add = document.getElementById("add");

add.addEventListener("click",()=>{

    //요소 만들기 : document.creatElement("태그명")
    //요소 제거하기 : 요소.remove();

    //요소의 클래스 목록 확인하기 : 요소.classList
    //요서의 class 추가: 요소.classList.add("클래스명")
    //요서의 class 제거: 요소.classList.remove("클래스명")

    //요소의 속성, 값 추가 : 요소.setAttribute("속성명", "값");
    //요소의 속성 제거     : 요소.removeAttribute("속성명");

    //부모요소.append(자식요소) :
    //부모 요소의 마지막 자식으로 자식 요소를 추가(덧붙이기)
    
    //부모요소.prepend(자식요소) :
    //부모 요소의 첫 번째 자식으로 자식 요소를 추가

    // A.after(B)  : A의 다음 요소로 B를 추가 

    // A.before(B) : A의 이전 요소로 B를 추가 
    

    //-----------------------------------------------
    //div 요소 만들기
    const div =document.createElement("div");
    div.classList.add("row"); //div에 row클래스 추가

    //-----------------------------------------------
    //input 요소 만들기
    const input =document.createElement("input");
    input.classList.add("in"); //input에 in클래스 추가
    input.setAttribute("type","number");
    //input에 type="numer" 속성 추가

     //-----------------------------------------------
     //span 요소 만들기
     const span = document.createElement("span")

     //span에 remove-row 클래스 추가
     span.classList.add("remove-row");

     //span에 &times;내용 추가(innerHTML 사용)
     span.innerHTML = " &times";

      // 만들어진 span 요소에 이벤트리스너 추가
    span.addEventListener("click", e => {
        // 클릭된 요소의 부모 요소를 삭제 == row 삭제
        e.target.parentElement.remove();
    });



     //----------------------
     //div의 자식으로 input추가
/*     div.append(input); */
    div.prepend(input);

    //div의 마지막 자식으로 span 추가
     div.append(span);

     //-----------------------------------------------

     //.container의 마지막 자식으로 div 추가
     document.querySelector(".container").append(div);
     

});

//삭제 버튼 동작 테스트 

//클래스가 remove-row인 요소 중 첫 번째 요소
document.querySelector(".remove-row").addEventListener("click",e=>{
    
    console.log(e.target);//이벤트가 발생한 요소(클릭된 버튼)

    //이벤트가 발생한 요소의 부모 요소(.row)
    console.log(e.target.parentElement);

    //이벤트가 발생한 요소의 부모 요소를 제거(remove())
    e.target.parentElement.remove();

});