package edu.kh.control.loop.practice;

import java.util.Scanner;

public class ForPractice {

	public void practice1() {

		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();

		if (input >= 1) {
			for (int x = 1; x <= input; x++) {
				System.out.print(x + " ");
			}
		} else
			System.out.println("1 이상의 숫자를 입력해주세요.");

	}

	public void practice2() {

		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();

		if (input >= 1) {
			for (int x = input; x >= 1; x--) {
				System.out.print(x + " ");
			}
		} else
			System.out.println("1 이상의 숫자를 입력해주세요.");

	}

	public void practice3() {

		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();

		int sum = 0;
		for (int i = 1; i <= input; i++) {
			sum += i;
			System.out.print(i);

			if (i != input) {
				System.out.print(" + ");
			}

		}
		System.out.print(" = " + sum);

	}

	public void practice4() {

		Scanner sc = new Scanner(System.in);

		System.out.print("첫 번째 숫자 : ");
		int num1 = sc.nextInt();

		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();

		if (num1 >= 1 && num2 >= 1) {
			if (num1 >= num2) {
				for (int i = num2; i >= num1; i++) {
					System.out.print(i);

				}
			} else if (num1 <= num2) {
				for (int x = num1; x >= num2; x++) {
					System.out.print(x);

				}
			}
		} else {
			System.out.println("1이상의 숫자를 입력해주세요.");
		}

	}

	public void practice5() {

		Scanner sc = new Scanner(System.in);

		System.out.print("숫자 : ");
		int dan = sc.nextInt();

		System.out.printf("==== %d단 ==== \n", dan);

		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d \n", dan, i, dan * i);
		}

	}

	public void practice6() {

		Scanner sc = new Scanner(System.in);

		System.out.print("숫자 : ");
		int dan = sc.nextInt();

		if (dan >= 2 && dan <= 9) {
			for (int i = dan; i <= 9; i++) {
				System.out.printf("==== %d단 ==== \n", i);
				for (int x = 1; x <= 9; x++) {
					System.out.printf("%d * %d = %d \n", i, x, i * x);
				}
			}
		} else {
			System.out.println("2~9사이의 숫자만 입력해주세요.");
		}

	}

	public void practice7() {

		Scanner sc = new Scanner(System.in);

		System.out.print("정수입력 : ");
		int input = sc.nextInt();

		for (int i = 1; i <= input; i++) {
			for (int x = 1; x <= i; x++) {
				System.out.print("*");

			}
			System.out.println();
		}

	}

	public void practice8() {

		Scanner sc = new Scanner(System.in);

		System.out.print("정수입력 : ");
		int input = sc.nextInt();

		for (int i = input; i >= 1; i--) {
			for (int x = i; x >= 1; x--) {
				System.out.print("*");

			}
			System.out.println();
		}

	}

	public void practice9() {

		Scanner sc = new Scanner(System.in);

		System.out.print("정수입력 : ");
		int input = sc.nextInt();

		for (int i = 1; i <= input; i++) {
			for (int x = input; x >= i; x--) {
				System.out.print(" ");
			}
			for (int p = 1; p <= i; p++) {
				System.out.print("*");
			}
			System.out.println();

		}
	}

	public void practice10() {

		Scanner sc = new Scanner(System.in);

		System.out.print("정수입력 : ");
		int input = sc.nextInt();

		for (int i = 0; i < 5; i++) { // 1~5번째 줄을 담당하는 for문
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < 4; i++) { // 6~9번째 줄을 담당하는 for문
			for (int j = 0; j < 4 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void practice13() {

		Scanner sc = new Scanner(System.in);

		System.out.print("자연수 하나를 입력하세요 : ");
		int input = sc.nextInt();

		int count = 1;

		for (int i = 1; i <= input; i++) {
			if (i % 2 == 0 || i % 3 == 0) {
				System.out.print(i + " ");
			}
				if (i % 2 == 0 && i % 3 == 0)
					count++;
		}
				System.out.println();
				System.out.printf("count: %d", count);
	}

}
