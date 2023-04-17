const container = document.getElementById("container");
const Btn = document.getElementById("createBtn");

Btn.addEventListener('click',()=>{

    const arr = []; //빈배열

  while(arr.length <6){ //arr에 저장된 값이 6개 미만인 경우 반복
        const random = Math.floor(Math.random()*45+1); //난수 생성

        //arr요소 중 중복되는 값 제거
        //==arr 요소 중 중복되는 값이 있으면 push를 안 하겠다.
        //==arr 요소 중 중복되는 값이 없으면 push를 하겠다.

        //배열명.indextOf(값): 값이 일치하는 요소의 index 반환
                        //  없으면 -1 반환
        if(arr.indexOf(random) == -1) //똑같은 값 없다! => 중복검사 코드!!
       arr.push(random);  //배열 마지막 요소 추가
    }

    //오름차순 정렬
    arr.sort((a,b)=> a-b); //정렬되는 함수~~~~~ 양수면 자리 바꿈

    for(let i=0; i<6; i++){
    container.children[i].innerText = arr[i];
    }

    
    
});
