package edu.kh.control.branch.ex;

import java.util.Scanner;

public class BranchEx {

	//분기문
	//break    : 가장 가까운 반복문을 멈춤(빠져 나감)
	//continue : 가장 가까운 반복문을 시작 부분으로 이동(다음 반복문으로 이동)
	
	//break 예시1
	public void ex1() {
		
		for(int i=1; i<=10000; i++) {
			System.out.println(i);
			
			if(i == 20) { //i가 20인 경우
				break; //반복문 멈춤
				
			}
			
		}
	}
	
	//break 예시 2
	
	public void ex2() {
	//0 입력 시까지 입력된 정수 합 구하기
	
	Scanner sc = new Scanner(System.in);
	
	int sum = 0; //합계 저장용 변수
	int input = 0; // 입력 값 저장용 변수
	

	while(true) { //무조건 조건식 true == 무한루프
		System.out.print("정수 입력 : ");
		input = sc.nextInt();
		
		if (input==0) {
			break; //while문을 종료
		}		
				
		sum += input;
		
	}
	System.out.print("합계 : " +sum);
	//Unreachable code
	
	}
	//break 예시 3
	
		public void ex3() {
			
			for(int row=1; row<=5; row++) {
				
				for(int col=1; col<=5; col++) {
					if(col==3) {
						break; //안쪽 for문 멈춤 
						//-> 2열까지만 출력
					}
					
					System.out.printf("(%d,%d)",row,col);
					}
				System.out.println(); //개행
				if(row==4) {
					break; //바깥쪽 for문 멈춤
					//->4행까지만 출력
				}
				
			}
					
		}
		
		public void ex4() {
			//1 2 3 4 5 6 7 8 9 10
			for(int i=1; i<=10; i++) {
				
				if(i%2 == 0) {
					continue;
					
				}
				
				System.out.println(i + " ");
			} 
			
		}
	
		public void ex5() {
			
		//1~100까지 1씩 증가하며 출력하는 반복문
		//단, 5의 배수는 출력을 건너뛰고
		//증가하는 값이 40이 되었을 때 반복을 멈춰라
			
			for(int i =1; i<=100; i++) {
				
//				if(i==40) {
//					break;
//				}	
				
				if(i%5==0) {

					if(i==40) {
						break;
					}else {
					continue;
					}
				}
				System.out.println(i);
			}			
		}	
		//분기문 응용1
		public void upDownGame() {
			
			//1~50사이의 난수를 하나 지정하여 
			//사용자가 몇 회만에 맞추는지 카운트하는 게임
			//만약 틀렸을 경우 난수가 크면 up, 작으면 down
			
			//난수 : math.random()
			// count, while, break
			
			//ex) 난수가 30인 경우
			
			//1번 입력: 10
			//up 
			
			//2번 입력: 40
			//Down
			
			//3번 입력 : 30
			//정답 입니다! (총 입력 횟수: 3회)
			
			Scanner sc = new Scanner(System.in);
			
			//1.난수 생성 (1~50)
			
			int x = (int)(Math.random() * 50 +1); 	//   0.0 <= x < 1.0
			
				
//			System.out.println("난수 : " + x);
			
			int count = 1 ;//반복 횟수 저장용 변수
			int input = 0;
			
			while(true) {
				System.out.println(count + "번 입력 : ");
				input = sc.nextInt();
				
				if(input == x ) { //입력값 == 난수(정답)
					System.out.printf("정답 입니다! (총 입력 횟수 : %d회)", count);
					break; //while문 종료
										
				} else if (input > x) { //입력값이 큰 경우
					System.out.println("DOWN");
					
				} else { //입력값이 작은 경우
					System.out.println("UP");
					
				}
								
				count++;
				
				
				
			}
			
			
		}

		public void ex6() {
			//시작 번호 부터 끝 번호까지 1씩 증가하며 출력하는 반복문
			// 특정 수의 배수를 입력 받아 출력모양 변경
			
			//시작: 5
			//종료: 13
			//제외할 배수: 6
			
			//5 [6] 7 8 9 10 11 [12] 13 14 15
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("시작 : ");
			int start = sc.nextInt();
			
			System.out.print("종료 : ");
			int end = sc.nextInt();
			
			System.out.print("제외할 배수 : ");
			int except = sc.nextInt();
			
			for(int i=start ; i<=end ; i ++) {
				
				if(i%except==0) {
					System.out.printf("[%d] ",i);
					
					
				} else	System.out.print(i + " ");
				
			
			}
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}