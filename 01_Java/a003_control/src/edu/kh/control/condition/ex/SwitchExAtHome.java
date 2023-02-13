package edu.kh.control.condition.ex;

import java.util.Scanner;

public class SwitchExAtHome {

	public void ex1() {

}
	public void ex2() {

		Scanner sc = new Scanner(System.in);

		int random = (int) (Math.random() * 3);
		// 0,1,2 중 하나를 무작위 발생

		String result;
		switch (random) {
		case 0:
			result = "백팀";
			break;
		case 1:
			result = "청팀";
			break;
		default:
			result = "홍팀";

		}

		System.out.println(result);

	}
	public void ex3() {

		Scanner sc = new Scanner(System.in);

		// 메뉴를 입력 받아서 가격이 얼마인지 출력하기

		System.out.print("메뉴를 입력하세요 (김밥/라면/샌드위치/떡볶이): ");

		String input = sc.next();
		
		int price; //가격을 저장할 변수 선언
		
		switch(input) {
		case "김밥" : 	price = 4500; break;
		case "라면" : 	price = 3500; break;
		case "샌드위치" : 	price = 5800; break;
		case "떡볶이" : 	price = 4000; break;
		default : price = -1; //잘못 입력한 경우에 사용하지 않는 숫자(-1)를 이용해서 표현
		}
		
		 if(price != -1) {
			 System.out.printf("%s는 %d원 입니다.", input, price);
		 }else { //price가 -1인 경우
			 System.out.println("존재하지 않는 메뉴 입니다.");
			 
		 }
	}
	
	
	public void ex4 () {
		Scanner sc = new Scanner(System.in);	
		
		
		System.out.print("정수1 입력 : ");
		int num1 = sc.nextInt();
		
		System.out.print("연산자 입력 : ");
		String op = sc.next();
		
		System.out.print("정수2 입력 : ");
		int num2 = sc.nextInt();
		
		
		switch(op) {
		case "+" : System.out.printf("%d %s %d = %.3f" , num1,op,num2, (double)num1 + num2); break;
		case "-" : System.out.printf("%d %s %d = %.3f" , num1,op,num2, (double)num1 - num2); break;
		case "*" : System.out.printf("%d %s %d = %.3f" , num1,op,num2, (double)num1 * num2); break;
		case "/" : 
				if(num2 == 0) {
					System.out.println("0으로는 나눌 수 없습니다."); break;
				}else {
					System.out.printf("%d / %d = %.3f" , num1,num2, (double)num1 / num2);
		
					System.out.println();break; 
		}
		case "%" : System.out.printf("%s %s %s = %.3f" , num1,op,num2, (double)num1 % num2); break;
		default	: System.out.println("존재하지 않는 연산자 입니다."); break;
	
	
	
	
	
	
	}
	
	}

}