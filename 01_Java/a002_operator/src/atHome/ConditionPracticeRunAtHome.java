package atHome;

import java.util.Scanner;

public class ConditionPracticeRunAtHome {
	public static void main(String[] args) {

		ConditionPracticeAtHome cp = new  ConditionPracticeAtHome();

		Scanner sc = new Scanner(System.in);

		System.out.println("예제 번호를 입력해주세요.");
		int input =sc.nextInt();

		switch(input) {
		case 1 :cp.ex1(); break; 
		case 2 :cp.ex2(); break;


		default : System.out.println("잘못 입력하셨습니다.");
		}


		}

}