package edu.kh.control.condition.practice;

import java.util.Scanner;

public class ConditionPracticeAtHome {
	
	public void ex1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڸ� �� �� �Է��ϼ��� : ");
		int input = sc.nextInt();
	
		
		 	 	
		if(input % 2 == 0 && input >= 1) {
			System.out.print("¦���Դϴ�"); 
		} else if(input % 2 != 0) {
			System.out.print("Ȧ���Դϴ�"); 
		} else {
			System.out.print("����� �Է����ּ���");
		}
	}

	public void ex2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�������� : ");
		int kor = sc.nextInt();
		
		System.out.print("�������� : ");
		int eng = sc.nextInt();
			
		System.out.print("�������� : ");
		int math = sc.nextInt();
		
		int sum = kor+eng+math;
		double avg = sum / 3.0;
	
		if(kor>=40 && eng>=40 && math>=40 && avg >=60) {
			System.out.println("���� : " + kor);
			System.out.println("���� : " + eng);
			System.out.println("���� : " + math);
			System.out.println("�հ� : " + sum);
			System.out.printf("��� %.1f \n: " , avg);
			System.out.println("�����մϴ�,�հ��Դϴ�");
		}else 
			System.out.println("���հ��Դϴ�.");
	
	}
	public void ex3() {
		
		
	
		
		
		
	}
	
	
	
	
	
	
	
}
