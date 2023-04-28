package edu.kh.project.member.model.service;

import edu.kh.project.member.model.dto.Member;

//Service Interface 사용 이유

//1. 프로젝트에 규칙성을 부여하기 위해서

//2. 클래스간의 결합도를 약화 시키기 위해서(객체 지향적 설계)
// ->유지보수성 향상

//3. Spring AOP 사용을 위해서
// -> AOP는 spring-proxu를 이용해서 동작하는데ㅔ
// 이때, Service 인터페이스가 필요하다!



public interface MemberService {
	

	/** 로그인 서비스
	 * @param inputMember(email,pw)
	 * @return email,pw가 일치하는 회원 정보 또는 Null
	 */
	Member login(Member inputMember);

	
	
	/**회원 가입 서비스(비밀번호 암호화 필요)
	 * @param inputMember
	 * @return 성공: 1 실패:0
	 */
	int signUp(Member inputMember);
	
	
}

