package edu.kh.operator.ex;

import java.util.Scanner; //Scanner import코드

public class OperatorEx1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); //Scanner 객체 생성
		
	//산술연산자 :  + - * / % (modulo, mod)(나머지)
		
    System.out.println("두 정수를 입력 받아 산술 연산 결과 출력하기");
    
    System.out.print("정수 입력 1 : ");
    int input1 = sc.nextInt ();
    
    System.out.print("정수 입력 2 : ");
    int input2 = sc.nextInt ();
    
    //\n ecape 문자 (기능을 가진 문자) - 줄바꿈	
    System.out.printf("%d + %d = %d \n", input1, input2, input1+input2);
    System.out.printf("%d - %d = %d \n", input1, input2, input1-input2);
    System.out.printf("%d * %d = %d \n", input1, input2, input1*input2);
    System.out.printf("%d / %d = %d \n", input1, input2, input1/input2);
    System.out.printf("%d %% %d = %d \n", input1, input2, input1%input2);
    //prinf에서 '%' 글자를 출력하고 싶으면 '%%'를 작성
	
	}

}
