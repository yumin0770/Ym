package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//서블릿 매핑에서 유효하지 않은 (url-pattern) [scope]
//->매핑할 주소 제일 앞에 "/"를 적지 않은 경우 발생하는 에러
@WebServlet("/scope") //"/" 최상위 주소를 나타내는 / 꼭 붙이기
public class ScopeController extends HttpServlet{

	//a태그, 주소창에 직접 작성, JS요청 시 GET 방식
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//요청 발송자
		RequestDispatcher dispatcher 	
//		= req.getRequestDispatcher("webapp폴더 기준으로 jsp경로 작성");
		= req.getRequestDispatcher("/WEB-INF/views/scope/scope.jsp");
		
		//1. page scope -> JSP에서 확인
		
		//2. request scope -> 요청 받은 페이지 + 위임 받은 페이지
		req.setAttribute("message","request scope에 저장된 메시지 입니다");
		
		//3. session scope -> 브라우저당 1개
//						   -> 브라우저 종료 또는 session 만료까지 유지
		//session 객체 얻어오는 방법
		HttpSession session = req.getSession();
		
		//*****  모든 scope는 속성을 세팅하고 얻어오는 방법이 동일하다    *****/
		session.setAttribute("sessionValue", "999");
		
		
		//4.application scope -> 서버가 켜지있는 동안 유지
		
		//application 객체를 얻어오는 방법
		//-> request, session 객체에서 얻어오기 가능
		ServletContext application = req.getServletContext();
//		ServletContext application = session.getServletContext(); => 결과 똑같음  application이 하나임
		
		application.setAttribute("addValue", 10000);
		
		
		
		// 모든 범위에 같은 key (str)로 속성 세팅
		
	
		req.setAttribute("str","request 범위에 세팅된 문자열");
		
		session.setAttribute("str","session 범위에 세팅된 문자열");
		
		application.setAttribute("str","application 범위에 세팅된 문자열");
		
		
		
		
		
		//요청 위임
		dispatcher.forward(req, resp);

		
		
		
		
		
	}
	

	
	
	
}
