const insertBtn = document.querySelector('#insertBtn');

//글쓰기 버튼 클릭 시
insertBtn.addEventListener("click",()=>{
    //JS BOM 객체 중 location (브라우저 관련 객체)
    //location.href = "주소"
    //해당 주소 요청(GET방식)

    location.href = `/board2/${location.pathname.split("/")[2]}/insert`;


});