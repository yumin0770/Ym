package study.main.view;

import java.util.InputMismatchException;
import java.util.Scanner;


import study.board.view.BoardView;
import study.common.Session;
import study.main.model.service.MainService;
import study.member.view.MemberView;

public class MainView {

	private Scanner sc =new Scanner(System.in);

	private MainService service = new MainService();
	
	//회원 기능 화면 객체 생성
	private MemberView memberView = new MemberView();
	
	//게시판 기능 화면 객체 생성
	private BoardView boardView = new BoardView();
	
	
public void mainMenu() {
		
	
	int input = 0; //input 담을 변수 선언
	
	//계속 실행해야 되기 때문에 do while문 사용
	do { 
		try {
			//로그인 X
			if(Session.loginMember == null) { 
				System.out.println("\n=====회원제 게시판 프로그램=====\n");
				System.out.println("1. 로그인");
				System.out.println("2. 회원 가입");
				System.out.println("3. 비밀번호 찾기");  //추가
				System.out.println("0. 프로그램 종료");
				
				System.out.print("\n 메뉴 선택 : ");
				input= sc.nextInt();
				sc.nextLine(); //입력 버퍼 개행 문자 제거
				
				switch(input) {
				case 1 :login(); break;
				case 2 :signUp(); break;
				case 3 :seachPw(); break;
				case 0: System.out.println("\n=== 프로그램 종료 ===\n");break;
				default : System.out.println("\n*** 메뉴 번호만 입력 해주세요. ****\n");
				}		
			}else {
				//로그인 O
				System.out.println("\n==== 로그인 메뉴 =====\n");
				System.out.println("1. 회원 기능");
				System.out.println("2. 게시판 기능");
				System.out.println("3. 로그아웃");
				System.out.println("0. 프로그램 종료");
				
				System.out.print("\n 메뉴 선택 : ");
				input= sc.nextInt();
				sc.nextLine(); //입력 버퍼 개행 문자 제거
					
				switch(input) {
				case 1 : memberView.memberMenu(); break;
				case 2 : boardView.boardMenu(); break;
				case 3 : 
					System.out.println("\n=== 로그아웃 되었습니다 ===\n");
					Session.loginMember = null;
					//참조하고 있던 로그인 회원 객체를 없앰
					break;
				case 0: System.out.println("\n=== 프로그램 종료 ===\n");break;
				default : System.out.println("\n*** 메뉴 번호만 입력 해주세요. ****\n");
			}//Session에서 로그인 유무 가져옴.
						}
					//로그인 O
		}catch(InputMismatchException e) {
			System.out.println("입력 형식이 바르지 않습니다.");
			sc.nextLine();  //입력 퍼버 문자열 제거
			e.printStackTrace();
			input = -1;  // while문 종료 방지		
		}
			
	}while(input != 0); //0이 되면 종료가 되기 때문에 0이 아니면 계속 do로 이어간다.
	
	
}
	private void login() {
		
		System.out.println("로그인");
		//아이디입력
		System.out.print("아이디 입력 : ");
		String memberId = sc.next();
		
		//비밀번호 입력
		System.out.print("비밀번호 입력 : ");
		String memberPw = sc.next();
		
		//서비스 호출(매개변수와 함께) - session에 저장
		Session.loginMember = service.login(memberId,memberPw);
		//로그인 완료
		
		//로그인 실패
		
		
		
		
	}
	
	
	
	
	
}