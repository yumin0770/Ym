import React from 'react';

//propt : 부모 컴포넌트가 자식 컴포넌트에게 
//데이터 전달 시 사용하는 객체
// **props는 자식-> 부모 데이터 전달은 불가능** 위에서 아래는 가능. 아래에서 위는 불가능

/* function test(){}  이런 함수 선언과 밑에 있는 것 차이 무엇??

test();  ->  함수 선언 호출 됨

but PropsEx(); -> 호출 X 
function있는 애들 먼저 찾음. 그 다음 위에서 아래로 해석을 함.*/

const ChildComponent = (props) =>{

    return (
        <> {/* 조각이라 부름 */}
            <ul>
                <li>이름: {props.name} </li>
                <li>나이: {props.age} </li>

            </ul>
        </>

    );

}

const MenuPrint = (props) => {

    return(
        <h4>김밥: {props.김밥}, 떡볶이 : {props.떡볶이}</h4>
    );


}


const PropsEx = (props) => {
    //props 매개변수 : 부모로 부터 전달받은 값이 담겨있는 객체
    //props 물려받음 . Props Drilling : 상태 내리꽂기

        console.log(props);
        console.log(props.name);

        const menu = {'김밥':3000, '떡볶이':4000};
        
return(
    <>
    <h1>{props.name}</h1>
    <ChildComponent name={props.name} age={props.name === '홍길동' ? 20 : 25} />
    <MenuPrint {...menu}/>
{/*     <MenuPrint 김밥={3000} 떡볶이={4000}/> */}
    </>
    );

}

export default PropsEx;