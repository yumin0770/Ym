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
		if (input % 2 == 0) {
			res = "짝수입니다.";
		}else (input % 2 ! == 0){
			res = "홀수입니다.";
		} default 
	       res = "양수만 입력해주세요"; break;
		
		System.out.println(res);
}

public void ex2() {
	
	}
public void ex3() {
	
	}
public void ex4() {
	
	}
public void ex5() {
	
	}


}