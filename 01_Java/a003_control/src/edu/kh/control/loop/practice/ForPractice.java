package edu.kh.control.loop.practice;

import java.util.Scanner;

public class ForPractice {

	public void practice1() {

		Scanner sc = new Scanner(System.in);

		System.out.print("1�̻��� ���ڸ� �Է��ϼ��� : ");
		int input = sc.nextInt();

		if (input >= 1) {
			for (int i = 1; i <= input; i++) {
				System.out.print(i + " ");
			}
		} else {
			System.out.print("1 �̻��� ���ڸ� �Է��ϼ���.");
		}
	}

	public void practice2() {

		Scanner sc = new Scanner(System.in);

		System.out.print("1�̻��� ���ڸ� �Է��ϼ��� : ");
		int input = sc.nextInt();

		if (input >= 1) {
			for (int i = input; i >= 1; i--) {
				System.out.print( i + " ");
			} 
		} else {
			System.out.print("1 �̻��� ���ڸ� �Է��ϼ���.");
		}
	}
	public void practice3() {

		Scanner sc = new Scanner(System.in);

		System.out.print("������ �ϳ� �Է��ϼ��� : ");
		int input = sc.nextInt();
		int sum = 0;

		for(int i = 1 ; i <= input ; i++) {
			sum += i; 
		 System.out.print(i);

		 //i == input == ������
		 if(i != input) { //!= �������� �ƴϴ�
			 System.out.print( " + ");
		 }
		}
		System.out.println(" = " + sum);

	}
	public void practice4() {

		Scanner sc = new Scanner(System.in);

		System.out.print("ù ��° ���� : ");
		int num1 = sc.nextInt();

		System.out.print("�� ��° ���� : ");
		int num2 = sc.nextInt();

		if( num1 >= 1 && num2 >= 1) {	
			for (int i = num1; i <= num2 ; i++) {
			System.out.print(i + " ");


		}} else {
			System.out.println("1�̻��� ���ڸ� �Է����ּ���.");
		}
		}

	public void practice5() {

		Scanner sc = new Scanner(System.in);

		System.out.print("���� : ");
		int dan = sc.nextInt();

		System.out.println("===== " + dan +"�� =====");
			for (int num = 1 ; num  <= 9 ; num ++) {
				System.out.printf("%d * %d = %2d \n", dan, num, dan * num);

			}
		}

	public void practice6() {

		Scanner sc = new Scanner(System.in);

		System.out.println("���� : ");
		int dan = sc.nextInt();

		if (dan >= 2 && dan <= 9) {
			for(int i = dan; i <= 9; i++) {
				System.out.printf("=====  %d�� ===== \n",i);
                for (int num = 1 ; num  <= 9 ; num ++) {
				System.out.printf("%d * %d = %2d \n", i, num, i * num);
			}

		} }else
		System.out.println("2~9 ���� ���ڸ� �Է����ּ���.");
	}


}

