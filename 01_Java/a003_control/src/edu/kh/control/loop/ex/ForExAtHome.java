package edu.kh.control.loop.ex;

import java.util.Scanner;

public class ForExAtHome {

	// for문 기초 사용법5
		public void ex5() {
			// 두 정수를 입력 받아
			// 두 정수 사이의 모든 정수의 합 출력하기
			// (단, 첫 번째 입력 받는 정수가 무조건 작다고 가정)

			// 정수 1 입력: 2
			// 정수 2 입력: 5
			// 2부터 5까지 모든 정수의 합:14
			
			Scanner sc = new Scanner(System.in);
			
			
			System.out.print("정수 1 입력 : " );
			int num1 = sc.nextInt();
			
			System.out.print("정수 2 입력 : ");
			int num2 = sc.nextInt();
			
			int sum =0;
			for(int i =2 ; i <= 5 ; i++) {
				sum += i;
			}
			System.out.printf("%d부터 %d까지 모든 정수의 합: %d",num1,num2,sum );
	
		}
		public void ex10() {
			// for + if 동시 사용

			// 1부터 10까지 반복하며 출력
			// 단, 짝수일 경우 ()로 숫자를 감싸서 출력

			// 1 (2) 3 (4) 5 (6) 7 (8) 9 (10)

			for (int i = 1; i <= 10; i++) {
				if(i % 2 == 0) {
					System.out.printf("(%d) " , i);
				} else
					System.out.printf("%d ",i);
	
	
	       }
		}
	
		public void ex11() {

			// 1부터 10까지 1씩 증가하며 출력
			// 단, 3의 배수인 경우 숫자를 [] 감싸서 출력
			// 단, 5의 배수인 경우 숫자 대신 '@' 출력
		
			for(int i=1; i<=10; i++) {
				if(i % 3 ==0) {
					System.out.printf("[%d] ",i);
				}else if(i % 5 ==0) {
					System.out.printf("@ ",i);
				}else 
					System.out.print(i + " ");
			}
			
		}	
		
		public void ex12() {

			// for, if, printf

			// 구구단 2단 출력하기
			// 2 x 1= 2
			// 2 x 9 = 18
		for(int i = 1; i<=9 ; i++) {
			System.out.printf("%d x %d = %d \n",2,i,2*i);
		}
		
	}
		
		public void ex13() {

			// 원하는 단을 입력 받아서 역순으로 출력

			// 단 입력: 3
			// 3 x 9 =27
			// 3 x 1 = 3
			
		Scanner sc = new Scanner(System.in);
		int dan = sc.nextInt();
		
		for(int i=9 ; i>=1 ; i++) {
			System.out.printf("%d x %d = %d \n",dan,i,dan*i);
		}
	}
		public void ex14() {

			// 입력 받은 단의 구구단 출력하기
			// 단, 입력 받은 단이 2~9사이가 아니라면
			// "잘못 입력하셨습니다."출력
			Scanner sc = new Scanner(System.in);
			int dan = sc.nextInt();
			
			if(2<= dan && 9>= dan) {
				for(int i = 1; i<=9 ; i++) {
					System.out.printf("%d x %d = %d \n",dan,i,dan*i);
			}}else 
				System.out.println("잘못 입력하셨습니다.");
			
			
			
		}
		public void ex18() {

			// 2중 FOR문을 이용하여 다음 모양을 출력하세요.

			// 1
			// 12
			// 123
			// 1234
		
			for(int x=1 ; x<=4; x++) {
				for (int i =1 ;  i <= x ; i++) {
					System.out.print(i);
				} System.out.println();
			} 
			
	
		}
		
		public void ex19() {
			// 2중 FOR문을 이용하여 다음 모양을 출력하세요.
			
			//4
			//43
			//432
			//4321
			
			for(int x =4; x>=1 ; x--) {
				for(int i=4 ; i>=x ; i--) {
					System.out.print(i);
				} System.out.println();
			}
		}
		public void ex20() {
			//입력된 정수 : 3
			//321
			//21
			//1
			
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			
			for(int x=input ; x>=1 ; x--) {
				for(int i=x ; i >=1 ; x-- ) {
					System.out.println(i);
				}
			}
		}	
		
		public void ex21() {
				
			int sum =0;
			int count = 0;
			
			for(int i=1;i<=20;i++) {
				if(i % 3==0) {
					sum+=i;
					count++;
				}
			}
			System.out.println("sum : " + sum);
			System.out.println("count : "+ count);
		}
	
		
		
}