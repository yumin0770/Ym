const createBtn = document.getElementById("createBtn");
const lottoBoard = document.getElementById("lottoBoard");


document.getElementById("createBtn").addEventListener("click",()=>{
                                 // 이전에 생성된 내용을 모두 삭제
     lottoBoard.innerHTML = ""; // 클릭할 때 마다 계속 번호가 삭제되는걸 방지

    let count = 1;
    for(let i = 1; i<=45;i++){  //1~45까지 증가
        //로또판에 들어갈 div 요소 생성
        const child = document.createElement("div");

        //child에 i(1~45) 값 대입
        child.innerText = count++;

        //child에 number 클래스 추가
        child.classList.add("number");

        // child가 클릭 되었을 때 배경색 변경/제거
        //+ 6개 넘으면 클릭 부락
        child.addEventListener("click",e=>{
            if(e.target.classList.contains("active")){
                e.target.classList.toggle("active");
            }else{
                //active클래스를 가진 요소가 6개 이상인 경우
                if(document.getElementsByClassName("active").length >= 6){
                    alert("6개 까지만 선택할 수 있습니다.")
                    return;
                } //active 클래스를 가진 요소가 6개 미만인 경우
                e.target.classList.toggle("active");
            }
        });
        //로또판에 child 추가
        lottoBoard.append(child);

       
}
});
