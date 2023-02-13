package edu.kh.control.condition.ex;

import java.util.Scanner;

public class ForPractice {

	public void practice1() {

		Scanner sc = new Scanner(System.in);

		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();

		if (input >= 1) {
			for (int i = 1; i <= input; i++) {
				System.out.print(i + " ");
			}
		} else {
			System.out.print("1 이상의 숫자를 입력하세요.");
		}
	}

	public void practice2() {

		Scanner sc = new Scanner(System.in);

		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();

		if (input >= 1) {
			for (int i = input; i >= 1; i--) {
				System.out.print( i + " ");
			} 
		} else {
			System.out.print("1 이상의 숫자를 입력하세요.");
		}
	}
	public void practice3() {

		Scanner sc = new Scanner(System.in);

		System.out.print("정수를 하나 입력하세요 : ");
		int input = sc.nextInt();
		int sum = 0;

		for(int i = 1 ; i <= input ; i++) {
			sum += i; 
		 System.out.print(i);

		 //i == input == 마지막
		 if(i != input) { //!= 마지막이 아니다
			 System.out.print( " + ");
		 }
		}
		System.out.println(" = " + sum);

	}
	public void practice4() {

		Scanner sc = new Scanner(System.in);

		System.out.print("첫 번째 숫자 : ");
		int num1 = sc.nextInt();

		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();

		if( num1 >= 1 && num2 >= 1) {	
			for (int i = num1; i <= num2 ; i++) {
			System.out.print(i + " ");


		}} else {
			System.out.println("1이상의 숫자를 입력해주세요.");
		}
		}

	public void practice5() {

		Scanner sc = new Scanner(System.in);

		System.out.print("숫자 : ");
		int dan = sc.nextInt();

		System.out.println("===== " + dan +"단 =====");
			for (int num = 1 ; num  <= 9 ; num ++) {
				System.out.printf("%d * %d = %2d \n", dan, num, dan * num);

			}
		}

	public void practice6() {

		Scanner sc = new Scanner(System.in);

		System.out.println("숫자 : ");
		int dan = sc.nextInt();

		if (dan >= 2 && dan <= 9) {
			for(int i = dan; i <= 9; i++) {
				System.out.println("===== " + dan + "단 =====");
                for (int num = 1 ; num  <= 9 ; num ++) {
				System.out.printf("%d * %d = %2d \n", dan, num, dan * num);
			}

		}} else
		System.out.println("2~9 사이 숫자만 입력해주세요.");



	}


}

