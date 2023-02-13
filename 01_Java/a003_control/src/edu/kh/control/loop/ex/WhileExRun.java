package edu.kh.control.loop.ex;

import java.util.Scanner;

public class WhileExRun {

	public static void main(String[] args) {
	
		WhileEx we = new WhileEx();


		Scanner sc = new Scanner(System.in);
		
		System.out.print("실행한 예제 번호를 입력 : ");
		int number = sc.nextInt();
		
		switch(number) {
		case 1 :we.ex1(); break; 
		case 2 :we.ex2(); break;
		case 3 :we.ex3(); break;
		case 4 :we.ex4(); break;
//		case 5 :we.ex5(); break;
		
		default : System.out.println("존재하지 않는 예시 번호입니다.");
		}
		
	}
	}


