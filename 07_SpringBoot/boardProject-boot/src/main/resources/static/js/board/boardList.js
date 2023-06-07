const insertBtn = document.querySelector('#insertBtn');

//글쓰기 버튼 클릭 시
if(insertBtn !=null){
insertBtn.addEventListener("click",()=>{
    //JS BOM 객체 중 location (브라우저 관련 객체)
    //location.href = "주소"
    //해당 주소 요청(GET방식)

    location.href = `/board2/${location.pathname.split("/")[2]}/insert`;


});
}

const boardSearch = document.querySelector("#boardSearch");
const searchKey = document.querySelector("#searchKey");
const searchQuery = document.querySelector("searchQeury");

const options = document.querySelector("searchKey > option");

//검색창 이전 검색 기록을 남겨놓기

(()=>{
    const params = new URL(location.href).searchParams;

    const key = param.get("key"); //t,c,tc,w 중 하나
    const query = params.get("query");

    if(key != null){
        searchQuery.value = query;

        //option태그를 하나씩 순차 접근해서 value가 key랑 같으면 
        //selected 속성 추가
        for(let op of options){
            if(op.value == key)
                op.selected == true;


        }
    }

})();

//검색어 입력 없이 제출된 경우
boardSearch.addEventListener("submit",e=>{

        if(searchQuery.value.trim().length==0){//검색어 미입력 시
            e.preventDefault();//form 기본 이벤트 제거

            location.href = location.pathname; //해당 게시판 1페이지로 이동

            //location.pathname : 쿼리스트링을 제외한 실제 주소

        }

});