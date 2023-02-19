package edu.kh.oop.method.view;

import java.util.Scanner;

import edu.kh.oop.method.service.MethodExService;
//View : 프로그램 실행 시 보여지는 부분
//-> 콘솔에 내용을 출력, 입력 받는 용도의 객체를 만들기 위한 클래스
public class MethodExView {



	//필드 (==멤버변수)
	private Scanner sc = new Scanner(System.in);
	//클래스 내 어디서든 사용 가능한 Scanner 객체 생성
	
	private MethodExService service = new MethodExService();
	//클래스 내 어디서든 사용 가능한 Scanner 객체 생성
	
	
	
//	public void ex1() {
//		sc.nextInt(); -> 위에 private scanner 만들어서 이렇게 줄여서 사용 가능
//	} 
	
	//void : 반환값이 없다.
	public void displayMenu () {//메뉴 표시(출력) 기능
		
		int input = 0; //입력 받은 정수를 저장할 변수
		do {	
			 System.out.println("---------------------------");
			 System.out.println("1. 매개 변수 X, 반환 값 X");
			 System.out.println("2. 매개 변수 O, 반환 값 X");
			 System.out.println("3. 매개 변수 X, 반환 값 O");
			 System.out.println("4. 매개 변수 O, 반환 값 O");
			 System.out.println("0. 프로그램 종료");
			 System.out.println("---------------------------");
			
			 System.out.print("메뉴 번호 입력 >>");
			 input = sc.nextInt();
			 System.out.println(); //개행
 
			 switch(input){
			 case 1 : menu1(); break; //1 입력 시 menu1() 메서드 호출
			 
			 case 2 : menu2(); break; //2 입력 시 menu2() 메서드 호출
			 
			 case 3 : menu3(); break;
			 case 4 : menu4(); break;
			 case 0 : System.out.println("<프로그램 종료>");break;
			 default :System.out.println("잘못 입력 하셨습니다.");
  
  
		  }
	 
	 
		}while(input !=0);
		
	} //displayMenu() 끝

	//1. 매개 변수 X, 반환 값X
	//[접근제한자][예약어] 반환형 메서드명([매개변수]) {}
	private void menu1() {   //()메서드 시그니쳐! 
		System.out.println("***menu1() 실행***");
		
		int a = 10;
		int b = 20;
		
		System.out.println("a + b = "+ (a+b));
		
	}
	//2.매개 변수 O, 반환 값 X
	private void menu2() {   //()메서드 시그니쳐! 
		System.out.println("***menu2() 실행***");
		
		System.out.println("[정수 3개를 입력 받아 합계, 평균을 출력]");
		
		System.out.print("입력 1: ");
		int num1 = sc.nextInt();
		
		System.out.print("입력 2: ");
		int num2 = sc.nextInt();
		
		System.out.print("입력 3: ");
		int num3 = sc.nextInt();
		
		
		//service에서 제공하는 기능
		//threeNumbersSumAndAverage(정수1, 정수2, 정수3) 호출 시
		//정수 1,2,3에 각각 num1,2,3를 전달함
		service.threeNumbersSumAndAverage(num1, num2, num3);
		
	}
	//3.매개 변수 X, 반환 값 O
	private void menu3() {
		System.out.println("***menu3() 실행***");
		
		System.out.println("[ 1부터 10사이의 난수 5개를 저장한 배열 반환 받아 출력]");
		
		int[] numbers = service.fiveRandomNumbers();
		
		//1)Service의 fiveRandomNumbers()를 호출
		//2) 난수 5개가 저장된 int[] 이 반환됨(돌아옴)
	     // -> 반환된 int[]은 실제 배열이 아닌 int[]의 주소값이 이다.=> 앝은 복사 개념 적용
		
		//3) 반환된 int[] 배열을 numbers 참조 변수에 저장
		
		for(int i=0; i<numbers.length; i++) {
			System.out.println(numbers[i]+" ");
			
		}
		System.out.println();// 개행
		
		//메서드 재사용
		service.threeNumbersSumAndAverage(numbers[0], numbers[1], numbers[2]);
		
		
	}
	//4. 매개 변수 O,반환 값 O
	private void menu4() {
		
	
		// 정수 2개, 연산자를 입력 받아 계산 서비스 호출 후 
		//연산 결과를 반환 받아서 출력
		
			System.out.println("***menu4() 실행***");
			System.out.println("[입력된 정수 2개, 연산자를 이용해서 계산하기]");
			
			System.out.print("정수 입력 1 : ");
			int num1 = sc.nextInt();
			
			System.out.print("연산자 입력 : ");
			String op = sc.next();
			
			System.out.print("정수 입력 2 : ");
			int num2 = sc.nextInt();
			
			//service의 calculate() 메서드 호출 시 매개변수 3개를 전달
			//-> 계산 결과가 String 형태로 반환
			String result = service.calculate(num1, num2, op);
			
			System.out.println(result);
			
	}	
	


	

}
