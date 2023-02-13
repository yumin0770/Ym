package edu.kh.control.condition.practice;

import java.util.Scanner;

public class ConditionPractice {


public void ex1() {
	Scanner sc = new Scanner(System.in);

	System.out.print("숫자를 한 개 입력하세요 : ");
	int input = sc.nextInt();

	String res;
	
	switch(input) {
	case 1 : 
		if (input > 0 && input % 2 == 0) {
			res = "짝수입니다."; break;
		}else {
			res = "홀수입니다."; break;
		} default :
	       res = "양수를 입력해주세요"; break;
	}	
		System.out.println(res);
}
public void ex2() {
	Scanner sc = new Scanner(System.in);
	
		System.out.print("援��댁���� : ");
		int kor = sc.nextInt();
		
		System.out.print("�������� : ");
		int math = sc.nextInt();
		
		System.out.print("���댁���� : ");
		int eng = sc.nextInt();
		
		String res;
		
		int grade 
		int sum = kor+math+eng;
		double avg = sum /3.0 ;
		
		switch(input) {
		case 1 : grade = 40 ; System.out.printf("%d",kor,kor); break;
		case 2 : grade = 40 ; System.out.printf("%d",math,math); break;
		case 3 : grade = 40 ;System.out.printf("%d",eng,eng); break;
		case 4 : grade = 40 ;System.out.printf("%d",sum,sum); break;
		case 5 : avg = 60 ; System.out.printf("%.1f",avg,avg); break;
	
	
		}	
	
	
    	System.out.println(res);
}
public void ex3() {
	
	}
public void ex4() {
	
	}
public void ex5() {
	
	}


}