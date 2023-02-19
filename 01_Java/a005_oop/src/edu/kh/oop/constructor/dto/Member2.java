package edu.kh.oop.constructor.dto;

public class Member2 {//캡슐화

		
	private String memberId  ="명시적 초기화";
	private String memberPw;
	private String memberName;
	private int memberAge;
	
	
	public static String programName;
		
	{
		memberId = "mem1";
		memberPw ="1234";
		memberName = "고길동";
		memberAge = 40;
		
		
	}
	
	static {
		programName = "회원관리 프로그램";
	}
	
	
	
	
	public Member2() {
		
		System.out.println("아이우에오ㅓ");
		
	}
	
	public Member2 (String memberId,String memberPw,
					String memberName, int memberAge) {
		
		
		System.out.println("매개변수 생성자(String,Stirng,String,int)로 생성");
	
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAge =  memberAge;
		
	}
	
	
	
	public Member2(String memberId) {
		
		this(); 
		
		this.memberId = memberId;
		
	}
	
	

	 
	public Member2(String memberId, String memberPw) {} //성립 (개수)가 달라서
	
	public Member2(String memberId, int memberAge) {} //성립 (타입)이 다름
	
	public Member2(int memberAge,String memberId) {} //성립 (순서)

	
	
}