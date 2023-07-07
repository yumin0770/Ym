import React, { useState, useContext } from 'react'; //변수 이름이 useState인 애를 가져오겠다.
import { TodoListContext } from './App';


const LoginComponent = () => {
    //전역변수를 사용
    const { setTodoList, setLoginMember, loginMember } = useContext(TodoListContext);

    const [id, setId] = useState('');
    const [pw, setPw] = useState('');

    const login =() => {
        fetch('/login',{
            method: "POST",
            headers : {
                //전달되는 데이터 타입
                'Content-Type' : 'application/json',

                //응답 데이터 타입
                'Accept' : 'application/json'
            },
            body : JSON.stringify({  //자바스크립형태는 String으로 바꿔줌
                id : id,
                pw : pw  //id,pw controller로 보내겠다
            })
        })
        .then(resp => resp.json()) //map형태로 받아옴
        .then(map => {
            console.log(map);
            
            //로그인 실패 시
            if(map.loginMember === null){
                alert('아이디 또는 비밀번호가 일치하지 않습니다');
                
                return;
            }

            //로그인 성공 시
            setLoginMember(map.loginMember);
            setTodoList(map.todoList);

        })
    };

    const logout =() => { 
        setLoginMember(null);
     };


    return( //화면 만드는 곳

    <div className="login-container">
    <table>
        <tbody>
            <tr>
                <th>ID</th>
                <td>
                    <input type="text" onChange={e => setId(e.target.value)} value={id} />
                </td>
            </tr>

            <tr>
                <th>PW</th>
                <td>
                    <input type="password" onChange={e => setPw(e.target.value)} value={pw} />
                </td>
                <td>
                    <button onClick={login} >Login</button>
                </td>
            </tr>
        </tbody>
    </table>

    {loginMember && ( //로그인 멤버가 있다면 (참이라면)
        <button onClick={logout}>로그아웃</button>
    )}
</div>
    )

}

export default LoginComponent;