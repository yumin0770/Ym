package edu.kh.jdbc.common;

import edu.kh.jdbc.member.model.dto.Member;

//로그인 : 기록된 회원 정보(DB)를 가지고 오는 것
// 		-> 로그아웃을 할 때 까지 프로그램에서 회원 정보가 유지
public class Session {
	
	public static Member loginMember = null; 
	
	//loginMemeber ==null ->로그아웃 상태
	//loginMember !=null ->로그인 상태
	//**Session클래스는 View에서만 사용 가능하다고 규칙 설정**

}
