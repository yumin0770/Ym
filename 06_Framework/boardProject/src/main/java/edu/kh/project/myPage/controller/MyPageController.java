package edu.kh.project.myPage.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.service.MyPageService;
import oracle.jdbc.driver.Message;

@SessionAttributes({"loginMember"})
//1) Model에 세팅된 값의 key와 {value} 작성된 값이 일치하면 Session scope로 이동
//2) Session으로 올려둔 값을 해당 클래스에 얻어와 사용 가능하게함
//-> @SessionAttribute(key)로 사용 s안 붙음

@RequestMapping("/myPage") // /myPage로 시작하는 요청을 모두 받음
@Controller //요청응답 제어 + Bean 등록(IOC)
public class MyPageController {

	@Autowired //MyPageService의 자짓 MyPageServiceImpl 의존성 주입(DI)
	private MyPageService service;
	
	
	@GetMapping("/info") //get방식 일 때
	public String info() {
		
		//ViewResolver 설정-> servlet-context.xml //WEB-INF/views//뺌
		return "myPage/myPage-info";
	}
	
	//프로필 페이지 이동
	@GetMapping("/profile")
	public String profile() {
		
		return "myPage/myPage-profile";
		
	}
	
	
	//비밀번호 변경 페이지 이동
	@GetMapping("/changePw")
	public String changePw() {
		
		return "myPage/myPage-changePw";
		
	}
	
	
	//탈퇴 변경 페이지 이동
		@GetMapping("/secession")
		public String secession() {
			
			return "myPage/myPage-secession";
			
		}
		
		//회원정보수정
		@PostMapping("/info")
		public String updateInfo(Member updateMember
				,String[] memberAddress
				,@SessionAttribute("loginMember") Member loginMember
				,RedirectAttributes ra) {
		
			//--------------매개변수 설명 -----------------
			//Member updateMember: 수정할 닉네임, 전화번호 , 주소 담긴 커맨드 객체
			//String[] memberAddress :  name="memberAddress"인 input 3개의 값 (주소)
			//@SessionAttribute("loginMember") Member loginMember
			// : Session에서 얻어온 "loginMember"에 해당하는 객체를 
			//매개변수 Member loginMember에 저장
			
			//RedirectAttributes ra : 리다이렉트 시 값 전달용 객체(request)
			//---------------------------------------------
			
			//주소 하나로 합치기<a^^^b^^^c>
			String addr = String.join("^^^", memberAddress);
			updateMember.setMemberAddress(addr);
			
			
			//로그인한 회원의 번호fmf updateMember에 추가
			updateMember.setMemberNo(loginMember.getMemberNo());
			
			//DB 회원정보 수정(UPDATE) 서비스 호출
			int result = service.updateinfo(updateMember);
			
			String message = null;
			
			if(result>0) { //성공
			
				message = "회원 정보가 수정되었습니다.";
				
				//Session에 로그인된 회원 정보도 수정(동기화)
				loginMember.setMemberNickname(updateMember.getMemberNickname());
				loginMember.setMemberTel(updateMember.getMemberTel());
				loginMember.setMemberAddress(updateMember.getMemberAddress());
				//참조변수(주소저장 session의 주소저장)
				
				
			}else  {  //실패
				
				message = "회원 정보가 수정실패되었습니다.";
			}
			
			ra.addFlashAttribute("message",message);
			
			return "redirect:info"; //상대경로(/myPage/info GET 방식)
		}
	
		//비밀번호 변경												// jsp->name = Sting name
		@PostMapping("/changePw") //changePw page로 이동하겠다 //어노테이션매개변수랑 Strin name이랑 같을 때 지우기
		public String changePW( String currentPw, String newPw
							,@SessionAttribute("loginMember") Member loginMember
							,RedirectAttributes ra){

				//로그인한 회원 번호 필요 (DB에서 어떤 회원을 조회,수정할지 알아야 되니까) //session에 "loginMember"값 존재
			int memberNo = loginMember.getMemberNo();  //->서비스로 전달
			
			//비밀번호 변경 서비스 호출
			int result = service.changePw(currentPw, newPw, memberNo);
					
			//비밀번호 변경 성공?
			String path = "redirect:";
			String message = null;
			
			if(result > 0) { //변경 성공
				message ="비밀번호가 변경 되었습니다.";
				path += "info";
			}else {
				message ="현재 비밀번화가 일치하지 않습니다";
				path += "changePw";
			}
			
			ra.addFlashAttribute("message",message);
			
			
			return path;
		}
		
		//회원 탈퇴
		@PostMapping("/secession")
		public String secession(String memberPw
				,@SessionAttribute("loginMember") Member loginMember
				,RedirectAttributes ra
				,SessionStatus status
				, HttpServletResponse resp) {
			
			//SessionStatus status  -> 세션관리객체
			// HttpServletResponse resp -> 클라이언트 응답 객체
			//RedirectAttributes ra -> 리다이텍트 시 reques로 값 전달하는 객체
			
			//String memberPw : 입력한 비밀번호 //탈퇴.jsp name
			
			//1. 로그인한 회원의 회원번호 얻어오기
			
			int memberNo = loginMember.getMemberNo();
			
			//2. 회원 탈퇴 서비스 호출
			int result = service.secession(memberPw,memberNo);
					
			String path = "redirect:";
			String message = null;
			
			//3. 탈퇴 성공 시
			if(result > 0) { //변경 성공
				
				//- 로그아웃
				status.setComplete(); 
				// - messgae : 탈퇴 되었습니다.
				message ="탈퇴 되었습니다.";
				//- 메인 페이지로 리다이렉트
				path += "/"; 
				
				//+쿠키 삭제
				Cookie cookie = new Cookie("saveId", "");
				//같은 쿠기가 이미 존재하면 덮어쓰기된다.
				
				cookie.setMaxAge(0); //0초 생존 -> 삭제한다
				cookie.setPath("/"); //요청 시 쿠키가 첨부되는 경로
				
				resp.addCookie(cookie); // 요청 객체를 통해서 클라이언트에게 전달
										// -> 클라리언트 컴퓨터에 파일로 생성
		
				//4.탈퇴 실패 시
			}else {
				//- messgae : 현재 비밀번호가 일치하지 않습니다
				message ="현재 비밀번호가 일치하지 않습니다";
				//- 회원 탈퇴 페이지로 리다이렉트
				path += "secession";
			}
			
			ra.addFlashAttribute("message",message);
			
			
			return path;
			
	
		}
		
		
		
		
	
	
}
