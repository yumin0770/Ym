package edu.kh.control.condition.practice;

import java.util.Scanner;

public class ConditionPracticeRunAtHome2 {
	public static void main(String[] args) {
		
		ConditionPracticeAtHome cp = new  ConditionPracticeAtHome();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� ��ȣ�� �Է����ּ���.");
		int input =sc.nextInt();
		
		switch(input) {
		case 1 :cp.ex1(); break; 
		case 2 :cp.ex2(); break;
	
		
		default : System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
		
		
		}

}
