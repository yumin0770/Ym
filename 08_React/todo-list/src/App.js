import React, { useState, createContext } from 'react';

import './App.css';

import SignupContainer from './Signup';
import Login from './Login';
import TodoList from './TodoList';

export const TodoListContext = createContext();//전역변수 생성

function App() {
  //회원가입, 로그인, 회원의 Todo List 출력/추가/제거
  const [signupView, setSignupView] = useState(false);

  //로그인한 회원 정보 저장 안쓸 땐 null
  const [loginMember, setLoginMember] = useState(null);

  //로그인한 회원의 todo-list를 저장
  const [todoList, setTodoList] = useState([]);


  
//setTodolist: setTodolist상태를 바꿔주는 세터
  return (
    <TodoListContext.Provider value={{setTodoList, setLoginMember, loginMember ,todoList}}> 
                        
      <button onClick={() => { setSignupView(!signupView) }}>
        {signupView ? ('회원 가입 닫기') : ('회원 가입 열기')}
      </button>

      <div className="signup-wrapper">
        {signupView === true && (<SignupContainer />)}
      </div>


      <h1>Todo List</h1>
      <Login/>
      
      <hr/>
    {/* 로그인이 되어 있을 때만 출력하겠다 */}
      {loginMember && (<TodoList/>)}  

    </TodoListContext.Provider>
  );
}

export default App;
