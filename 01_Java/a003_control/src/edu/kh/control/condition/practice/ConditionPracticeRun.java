package edu.kh.control.condition.practice;

import java.util.Scanner;

public class ConditionPracticeRun {

	public static void main(String[] args) {
	
		ConditionPractice cp = new  ConditionPractice();
  
		
			Scanner sc = new Scanner(System.in);
			
			System.out.print("실행한 예제 번호를 입력 : ");
			int number = sc.nextInt();
			
			switch(number) {
			case 1 :cp.ex1(); break; 
			case 2 :cp.ex2(); break;
			case 3 :cp.ex3(); break;
			case 4 :cp.ex4(); break;
			case 5 :cp.ex5(); break;
			
			default : System.out.println("존재하지 않는 예시 번호입니다.");
			}
			
		}
}
