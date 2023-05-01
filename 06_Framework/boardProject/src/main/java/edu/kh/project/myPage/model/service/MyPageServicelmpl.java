package edu.kh.project.myPage.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.dao.MyPageDAO;

@Service //비지니스 로직 처리 클래스 + Bean으로 등록(IOC)
public class MyPageServicelmpl implements MyPageService {
	//인터페이스 쓰는 이유 여러가지~~
	
	//스프링이 만든거 가져오는거 autowired
	@Autowired //MyPageDAO 의존성 주입(DI)
	private MyPageDAO dao;
	
	@Autowired // BCryptPasswordEncoder 의존성 주입(DI)
	private BCryptPasswordEncoder bcrypt;
	
	// 스프링에서는 트랜잭션을 처리할 방법을 지원해줌.(코드기반, 선언적)
	   // 1) <tx:advice> -> AOP를 이용한 방식(XML에 작성)
	   // 2) @Transactional 어노테이션을 이용한 방식(클래스 또는 인터페이스에 작성)
	   // - 인터페이스를 구현한 클래스로 선언된 빈은 인터페이스 메소드에 한해서 트랜잭션이 적용됨
	   // * 트랜잭션 처리를 위해서는 트랜잭션 매니저가 bean으로 등록되어 있어야 함. 
	   //   -> root-context.xml 작성
	   
	   // 정상 여부는 RuntimeException이 발생했는지 기준으로 결정되며, 
	   // RuntimeException 외 다른 Exception(대표적으로 SQLException 등)에도 트랜잭션 롤백처리를 적용하고 싶으면 
	   // @Transactional의 rollbackFor 속성을 활용하면 된다
	

	//회원정보수정 서비스
	@Transactional(rollbackFor = {Exception.class})
	@Override
	public int updateinfo(Member updateMember) {
		return dao.updateInfo(updateMember);
	} 
	
	//@Transactional ///unchecked Exception 발생 시 rollback
	@Transactional(rollbackFor = {Exception.class}) //모든 Exception 발생 시 rollback
	@Override
	public int changePw(String currentPw, String newPw, int memberNo){
		
		//1.현재 비밀번호, db에 저장된 비밀번호 비교
			//1) 회원번호 일치하는 MEMBER 테이블 행의 MEMBE_PW 조회
		String encPw = dao.selectEncPw(memberNo);
		//이미 변경된 비밀번호 조회
		
			
			//2)brcypt.matches(평문, 암호문) -> 같으면 true ->이 때 비번 수정
		if(bcrypt.matches(currentPw, encPw)) {
			//2. 비밀번호 변경(Update DAO 호출) -> 결과 반환
			return dao.changePw(bcrypt.encode(newPw), memberNo);	
								//암호화
				
		}
			//3)비밀번호가 일치하지 않으면 0 반환
		
		return 0;
	}
	
	//회원탈퇴 서비스
	@Transactional(rollbackFor = {Exception.class})
	@Override
	public int secession(String memberPw, int memberNo) {
		
		String encPw = dao.selectEncPw(memberNo);

		// - 비밀번호가 일치하면 MEMBER_DEL_FL -> 'Y'로 바꾸고 1반환
		if(bcrypt.matches(memberPw, encPw)) {
			return dao.secession(bcrypt.encode(memberPw), memberNo);	
			
		}	
		// - 비밀번호가 일치하지 않으면 -> 0 반환
		return 0;
	}
	
	
}
