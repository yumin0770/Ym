package edu.kh.control.loop.practice;

import java.util.Scanner;

public class ForPractice2 {

	public void practice1() {

		Scanner sc = new Scanner(System.in);

		System.out.print("1�댁���� �レ��瑜� ���ν���몄�� : ");
		int input = sc.nextInt();

		if (input >= 1) {
			for (int i = 1; i <= input; i++) {
				System.out.print(i + " ");
			}
		} else {
			System.out.print("1 �댁���� �レ��瑜� ���ν���몄��.");
		}
	}

	public void practice2() {

		Scanner sc = new Scanner(System.in);

		System.out.print("1�댁���� �レ��瑜� ���ν���몄�� : ");
		int input = sc.nextInt();

		if (input >= 1) {
			for (int i = input; i >= 1; i--) {
				System.out.print( i + " ");
			} 
		} else {
			System.out.print("1 �댁���� �レ��瑜� ���ν���몄��.");
		}
	}
	public void practice3() {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("����瑜� ���� ���ν���몄�� : ");
		int input = sc.nextInt();
		int sum = 0;
			
		for(int i = 1 ; i <= input ; i++) {
			sum += i; 
		 System.out.print(i);
		 
		 //i == input == 留�吏�留�
		 if(i != input) { //!= 留�吏�留��� ������
			 System.out.print( " + ");
		 }
		}
		System.out.println(" = " + sum);
	
	}
	public void practice4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("泥� 踰�吏� �レ�� : ");
		int num1 = sc.nextInt();
		
		System.out.print("�� 踰�吏� �レ�� : ");
		int num2 = sc.nextInt();
		
		if( num1 >= 1 && num2 >= 1) {	
			for (int i = num1; i <= num2 ; i++) {
			System.out.print(i + " ");
			
			
		}} else {
			System.out.println("1�댁���� �レ��瑜� ���ν�댁＜�몄��.");
		}
		}
		
	public void practice5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�レ�� : ");
		int dan = sc.nextInt();
		
		System.out.println("===== " + dan +"�� =====");
			for (int num = 1 ; num  <= 9 ; num ++) {
				System.out.printf("%d * %d = %2d \n", dan, num, dan * num);
				
			}
		}
	
	public void practice6() {
		
		Scanner sc = new Scanner(System.in);
	
		System.out.println("�レ�� : ");
		int dan = sc.nextInt();
		
		if (dan >= 2 && dan <= 9) {
			for(int i = dan; i <= 9; i++) {
				System.out.println("===== " + dan + "�� =====");
			}
			
		} System.out.println("�レ�� : ");
		int number = sc.nextInt();
		System.out.println("2~9 �ъ�� �レ��留� ���ν�댁＜�몄��.");
		
	
		
	}
	
	
}
	
	
	

