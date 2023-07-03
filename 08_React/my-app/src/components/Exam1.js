import React, { Component } from 'react';

//components 폴더의 Exa,1.js를 가져와서 사용
//사용할 때 이름을 Ex1으로 지정



//node-moduls 폴더에 있는 react 패키지를 가져옴

//클래스형 컴포넌트 만들기
//1. Component 상속 받기
//2. render() 함수 작성하기(필수)
//3. 만든 클래스를  export defaul 지정하기
// Component 예제
// 리액트 컴포넌트를 만들 땐 리액트를 불러와야함,
//클래스형 컴포넌트는 react에서 Component를 불러와야합니다.
// 클래스형 컴포넌트
class Exam1 extends Component {
    constructor(props) {
        super(props);
        this.state = { count: 0 };
    }
    handleClick = () => {
        this.setState({ count: this.state.count + 1 });
    }
    render() { // 클래스형 컴포넌트는 render 함수 안에 return 구문을 넣어줘야합니다. 무엇을 렌더링할지


            return(
                <>
                    <h2>클래스형 컴포넌트</h2>
                    <h1>Count: {this.state.count}</h1>
                    <button onClick={this.handleClick}>Increment</button> {/* 이 단위를 컴포넌트라 한다. */}
                </> 
            );
    }
    /* doc.getElyId.addEventLisnener 등등 코드 가져왔을 것. */
}
export default Exam1;