package edu.kh.oop.constructor.run;

import java.util.Scanner;

import edu.kh.oop.constructor.dto.Member2;

public class ConstructorRun2 {
	public static void main(String[] args) {
	
		//회원 생성
		Member2 mem1 = new Member2();//기본 생성자를 이용해서 Member객체 생성
		
		//매개변수 생성자를 이용해서 Member 객체 생성
		Member2 mem2 = new Member2("user02.","pass02","김삼순",19);  //기본 생성자를 이용해서 Member객체 생성

		
		Member2 mem3 = new Member2("user9999"); 
		
		
		
		
		System.out.println(Member2.programName);
		
		System.out.println("-----------------");
		
		
	
}

}
