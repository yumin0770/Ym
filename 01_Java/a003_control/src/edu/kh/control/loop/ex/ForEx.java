package edu.kh.control.loop.ex;

import java.util.Scanner;

public class ForEx {
	/*
	 * for문 - 끝이 정해져 있는 경우에 사용하는 반복문 (== 반복 횟수가 지정되어 있는 경우 사용)
	 * 
	 * -작성법
	 * 
	 * for(초기식[1]; 조건식[2][5]; 증감식[4][7]){
	 * 
	 * [3][6]조건식이 true일 때 반복 수행할 코드 }
	 * 
	 * 1~4 번 수행 후 조건식이 false가 나올 때 까지 5~7을 반복
	 * 
	 * - 초기식 : for문을 제어하는 용도의 변수 선언 및 초기화 (변수에 값을 처음 대입하는것 초기화)
	 * 
	 * - 조건식 : for문의 반복 여부를 지정하는 식 조건식이 true인 경우에만 반복 수행을 함. 보통 초기식에 사용된 변수를 이요행서
	 * 조건식을 작성함.
	 * 
	 * - 증감식 : for문이 한 번 반복을 수행할 때 마다 마지막에 특정 값을 증가 또는 감소 시키는 식
	 * 
	 * 보통 초기식에 사용된 변수를 증가/감소 시켜 조건식의 결과를 변화하게 만드는 용도
	 * 
	 **/

	// for문 기초 사용법1
	public void ex1() {

		// 1~10까지 반복 출력
		// 1,2,3,4,5,6,7,8,9,10,11 (1부터 시작, 1씩 증가, 11에서 멈추고 싶음)

		for (int num = 1; num <= 10; num++) { // 해석시 초기식, 증감식, 조건식
			// num은 1~10까지 1씩 증가하는 변수
			System.out.println(num);

		}
	}

	public void ex2() {
		// 5부터 12까지 1씩 증가하며 출력
		for (int num = 5; num <= 12; num++) {
			System.out.print(num + " ");
		}
	}

	// for문 기초 사용법 3
	public void ex3() {
		// 3부터 20까지 2씩 증가하며 출력

		for (int i = 3; i <= 20; i += 2) {
			// i = i +2
			System.out.print(i + " ");
		}
	}

	public void ex4() {
		// 1부터 100까지의 모든 정수의 합 == 5,050

		int sum = 0; // i가 증가하면서 변한 값들을 누적할 변수
						// 0으로 초기화 하는 이유 : 어떤 값을 더하든 영향이 없어서
		for (int i = 1; i <= 100; i++) {

			sum += i; // = sum = i + 1

		}

		System.out.println("합계 : " + sum);
	}

	// for문 기초 사용법5
	public void ex5() {
		// 두 정수를 입력 받아
		// 두 정수 사이의 모든 정수의 합 출력하기
		// (단, 첫 번째 입력 받는 정수가 무조건 작다고 가정)

		// 정수 1 입력: 2
		// 정수 2 입력: 5
		// 2부터 5까지 모든 정수의 합:14

		Scanner sc = new Scanner(System.in);

		System.out.print("정수 1 : ");
		int num1 = sc.nextInt();

		System.out.print("정수 2 : ");
		int num2 = sc.nextInt();

		int sum = 0;
		for (int i = num1; i <= num2; i++) {
			sum += i;

		}
		System.out.printf("%d부터 %d까지 모든 정수의 합 : %d", num1, num2, sum);
	}

	// for문 기초 사용법6 //**암기
	public void ex6() {

		// 다른 자료형으로 for문 사용하기
		// 10부터 20까지 0.5씩 증가하며 출력
		for (double i = 10; i <= 20; i += 0.5) { // 형변환 대입연산인 경우에는 대입에 맞춰짐
			// 초기식을 int형을 지정하게 되는 경우 무한루프에 빠지게 된다.
			// 왜? i += 0.5 수행 시 10.5가 아닌
			// 10으로(int형으로) 형변환되어 i에 대입되기 때문에

			// 해결 방법 : 초기식을 double 자료형으로 변경

			System.out.println(i);

		}

		System.out.println("-------------------------------");
		// A-Z까지 모든 알파벳 출력하기

		// 1) A, Z의 유니코드 번호 이용하기(아스키 코드)
		for (int i = 65; i <= 90; i++) {
			System.out.print((char) i);
		}

		// 2) 유니코드 번호를 모를 때
		System.out.println();
		for (int i = 'A'; i <= 'Z'; i++) {
			System.out.print((char) i);

		}

		// 3) char 자료형은 문자형이지만 실제로는 정수를 저장한다!
		System.out.println();
		for (char i = 'A'; i <= 'Z'; i++) {
			System.out.print(i);
		}

	}

	// for문 응용 사용법1
	public void ex7() {
		// 감소하기
		// 10부터 1까지 1씩 감소하며 출력
		for (int i = 10; i >= 1; i--) {
			System.out.print(i + " ");
		}

	}

	// for문 응용 사용법2
	public void ex8() {
		// 입력, 합계, for

		// 정수 5개를 입력 받아 합계 출력하기

		Scanner sc = new Scanner(System.in);

		int sum = 0; // 합계를 저장할 변수 선언 및 0으로 초기화

		for (int i = 1; i <= 5; i++) {// 1부터 5까지 1씩 증가 (5회반복)
			System.out.printf("정수 입력 %d :", i);
			sum += sc.nextInt();

		}

		System.out.print(sum);

	}

	// ex9번 응용 3
	public void ex9() {

		// 정수를 몇 번 입력 받을지 먼저 입력하고
		// 입력된 정수의 합계를 출력하라

		// 입력 받을 정수의 개수 : 2
		// 입력 1 : 3
		// 입력 2 : 5
		// 합계 : 8

		// 입력 받을 정수의 개수 : 4
		// 입력 1: 3
		// 입력 2: 5
		// 입력 3 : 1
		// 입력4 : 2
		// 합계 : 11

		Scanner sc = new Scanner(System.in);

		System.out.printf("입력 받을 정수의 개수 : ");
		int num = sc.nextInt();

		int sum = 0;
		for (int i = 1; i <= num; i++) {
			System.out.printf("입력 %d :", i);
			sum += sc.nextInt();

		}

		System.out.printf("합계 : %d ", sum);

	}

	// for문 응용 사용법 4
	public void ex10() {
		// for + if 동시 사용

		// 1부터 10까지 반복하며 출력
		// 단, 짝수일 경우 ()로 숫자를 감싸서 출력

		// 1 (2) 3 (4) 5 (6) 7 (8) 9 (10)

		for (int i = 1; i <= 10; i++) {

			// 짝수인 경우
			if (i % 2 == 0) {
				System.out.printf("(%d) ", i);
			} else
				System.out.print(i + " ");
		}

	}

	// for문 응용 사용법 5
	public void ex11() {

		// 1부터 10까지 1씩 증가하며 출력
		// 단, 3의 배수인 경우 숫자를 [] 감싸서 출력
		// 단, 5의 배수인 경우 숫자 대신 '@' 출력

		for (int i = 1; i <= 10; i++) {
			if (i % 3 == 0) { // 3의 배수
				System.out.printf("[%d] ", i);
			} else if (i % 5 == 0) { // 5의 배수
				System.out.print("@ ");
			} else
				System.out.print(i + " ");

		}

	}

	// for문 응용 사용법 6 구구단
	public void ex12() {

		// for, if, printf

		// 구구단 2단 출력하기
		// 2 x 1= 2
		// 2 x 9 = 18

		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d X %d = %2d \n", 2, i, 2 * i);
		}

	}

	// for문 응용 사용법 7 구구단
	public void ex13() {

		// 원하는 단을 입력 받아서 역순으로 출력

		// 단 입력: 3
		// 3 x 9 =27
		// 3 x 1 = 3

		Scanner sc = new Scanner(System.in);

		System.out.print("단 입력 : ");
		int num = sc.nextInt();

		for (int i = 9; i >= 1; i--) {
			System.out.printf("%d x %d = %2d \n", num, i, num * i);
		}

	}

	// for문 응용 사용법 8
	public void ex14() {

		// 입력 받은 단의 구구단 출력하기
		// 단, 입력 받은 단이 2~9사이가 아니라면
		// "잘못 입력하셨습니다."출력

		Scanner sc = new Scanner(System.in);
		System.out.print("단 입력 : ");
		int num = sc.nextInt();

		if (num >= 2 && num <= 9) { // 조건을 먼저 설정 (input < 2 || input >9)
			for (int i = 1; i <= 9; i++) {
				System.out.printf("%d x %d = %2d \n", num, i, num * i);
			}
		} else
			System.out.print("잘못 입력 하셨습니다.");

	}

	// 중첩 반복문
	public void ex15() {

		// 12345 연달아 수업

		// 1), 2), 3) 코드를 작성하기위해 생각한 순서
		for (int x = 1; x <= 5; x++) { // 3) 4회 반복

			for (int i = 1; i <= 5; i++) { // 1)1234 출력
				System.out.print(i);

			}
			System.out.println(); // 2) 줄바꿈(개행)
		}
	}

	// 중첩 반복문 기본 사용법2
	public void ex16() {

		// 1 2 3 4 5
		// 2 4 6 8 10
		// 3 6 9 12 15
		// 4 8 12 16 20
		// 5 10 15 20 25

		for (int x = 1; x <= 6; x++) {
			for (int i = 1; i <= 5; i++) {
				System.out.printf("%3d", x * i);
			}
			System.out.println();
		}
	}

	// 중첩 반복문 응용 사용법1
	public void ex17() {
		// 구구단을 2단 부터 9단까지 모두 출력하기

		// 2x1 =2 2x2=4 ...

		for (int dan = 2; dan <= 9; dan++) {
			for (int num = 1; num <= 9; num++) {
				System.out.printf("%dx%d=%d ", dan, num, dan * num);

			}
			System.out.println();
		}
	}

	// 중첩 반복문 응용 사용법1
	public void ex18() {

		// 2중 FOR문을 이용하여 다음 모양을 출력하세요.

		// 1
		// 12
		// 123
		// 1234

		for (int x = 1; x <= 4; x++) { // 4번 반복
			for (int i = 1; i <= x; i++) { // 한 줄 출력
				System.out.print(i);

			}
			System.out.println();
		}
	}


	// 중첩 반복문 응용 사용법3
	public void ex19() {
		// 2중 FOR문을 이용하여 다음 모양을 출력하세요.
		
		//4
		//43
		//432
		//4321
		
		for (int x = 4; x >= 1; x--) { // 4번 반복 x=4,3,2,1
			for (int i = 4; i >= x; i--) { // 한 줄 출력
				System.out.print(i);

			}
			System.out.println();
		}
	
	}
	// 중첩 반복문 응용 사용법4
	public void ex20() {
		//입력된 정수 : 3
		//321
		//21
		//1
		
		//입력된 정수 : 4
		//4321
		//321
		//21
		//1
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력된 정수 : ");
		int input = sc.nextInt();

		for(int x = input; x >= 1; x-- ) { // 3,2,1
			for(int i = x; i>=1; i-- ) {
				System.out.print(i);
				
			}
			System.out.println();
			
		}
	}
	//카운트(개수 세기)
	public void ex21() {
		//1부터 20사이의 3의 배수의 합과 개수를 출력
		//3 6 9 12 15 18
		
		
		//sum : 63
		//count : 6
		
		int sum = 0; //합계 저장용 변수
		int count = 0; //카운트용 변수
		
		for(int i= 1; i<=20; i++) {
			if(i % 3 == 0) { //3의 배수인 경우
				sum+= i;
				count++;
				
			}
		}
		System.out.println("sum : " + sum);
		System.out.println("count : "+ count);
	}


	//count를 이용한 이중 for문
		public void ex22() {
			
			// 1  2  3  4
			// 5  6  7  8
			// 9 10 11 12
			
			int count = 1; //숫자를 세기위한 변수 선언
			
			for(int row=1 ; row<=3; row++) {//3줄 (3행)
				for(int col=1; col <=4; col++) { //4열
				
					System.out.printf("%3d", count++); //count++ 밖에 있었는데 안으로 들어옴
					// 후위연산 카운트 다하고 연산돼서 괄호 안으로 들어가도 똑같음.
					
					
					
				}
				System.out.println(); //개행
				
			}
			
			
			
			
			
		}
	
		
	



}