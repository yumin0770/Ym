package edu.kh.exception.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.exception.user.exception.ScoreInputException;

public class ExceptionService2 {

	public void ex1() throws IOException {
				//해당 메서드 내에서 IOExcen이 발생것을 대비한 예비처리 코드

		
		//예외(Exception) 확인하기
		
		//키보드 입력을 효율적으로 읽어오는 객체
		//Scanner보다 기능은 부족하지만 속도는 빠름
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("입력 : ");
		String input = br.readLine();
		//readLine() : 한 줄 읽어오기(엔터까지)
		//왜 빨간줄이뜰까??
		///원래 -readLine() 메서드는 10Exceptrion 이라고 하는 예외를
		//발생시킬 (던질) 가능성이 있기 때문에
		//그 상황에 대한 대비책(예외처리)를 하라고 경고하는 것.

		System.out.println("입력값 : " + input) ;

// 		Class Exception은 모든 예외의 최상위 부모
//     	
//		Class IOException		
//		JAVA 프로그램 실행 중
//		Exception상황이 발생하면
//		해당 상황과 일치하는 예외 클래스를 찾아서
//		객체로 만들어서문제가 발생한 위치로 던짐.
		
		
		
		//Checked Exception : 
		//컴파일 단계에서 예외가 발생할 가능성이 있는지
		//반드시 확인해야하는 예외
		
		//-> 공식 API 문서의 메서드 설명에 
		// throws OOO Exception 으로 작성 되어있는 메서드가 있으면
		// 해당 코드 사용시 문제가 발생할 것이다라고 생각하고
		// 그 상황에 대한 예외 처리 코드를 꼭 작성
		
		
		//Unchecked Exception : 
		//컴파일 단계에서 예외가 발생할 가능성이 있는지 
		//확인하지 않는 예외
		
		//-> 개발자의 부주의로 나타나는 예외
		// ---> 대부분 쉽게 해결 (if)
		
		//->치명적인 문제가 아님
		
		System.out.println(5/0);
		
		int[] arr = new int[5];
		System.out.println(arr[10]);
		
		String s =null;
		System.out.println(s.equals("bbB"));

		
	}
	
	public void ex2() {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		try {
		System.out.println("입력 : ");
		String input = br.readLine();

		} catch(IOException e) {
		
			System.out.println("키보드 문제로 입력을 진행할 수 없습니다.");
	
		}
		System.out.println("try-catch가 수행되도 프로그램이 종료되지 않음");
	
	}
	
	public void ex3() {
	
		Scanner sc = new Scanner(System.in);
		
		try { 
			System.out.print("입력 1 : ");
			int num1 = sc.nextInt();
						
			System.out.print("입력 2: ");
			int num2 = sc.nextInt();
			
			System.out.printf("%d / %d = %d \n ",num1,num2,num1/num2);
			
//			if(num2==0) {
//				System.out.println();
//			}

		}catch(ArithmeticException e ) {
			 System.out.println("0으로 나눌 수  없습니다.");
			}catch(InputMismatchException e) {
				System.out.println("입력이 잘못되었습니다.");
			}
		
			finally { 
				System.out.println("프로그램 종료");
	 }
		
	}

	public void ex4() {
	
		// throw : 예외 강제 발생
		//  	 ex) throw new IOException();
		
		//throws : 해당 메서드에서 발생한 예외를
	   //	 		호출한 메서드로 던져버리는 예외 처리 방법
		
		System.out.println("ex4() 실행");
		
		try {
			methodA();
			
		}catch(IOException e) {
//			e.getMessage() //어떤것 때문에 발생했는지 메세지
			
			e.printStackTrace();
			// Trace : 추적하다
			// -> 예외가 발생한 지점까지의 stack 메모리를 추적하여 출력
			
			System.out.println("catch문 처리");
			
		}
		
	}
	
	public void methodA() throws IOException {
		System.out.println("methodA() 실행");
		
		methodB();
	}
	
	public void methodB() throws IOException {
		System.out.println("methodB() 실행");
		
		methodC();
		//methodC()는 IOException을 던질 수도 있기 때문에 호출 시 예외 처리 구문을 작성해야 한다.
	}
	
	public void methodC() throws IOException {
		System.out.println("methodC() 실행");	
		
		throw new IOException();
	}

	
	public void ex5() throws ScoreInputException{
		//사용자 정의 예외
		// -JAVA에서 제공하지 않는 예외 상황이 있을 경우
		// 이를 처리하기 위한 예외 클래스를 사용자가 직접 작성/생성
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("점수 입력(0~100) : ");
		int score = sc.nextInt();
		
		if(score < 0 || score >100) {
			//사용자 정의 예외 강제 발생
	//		throw new ScoreInputException(); //기본 생성자
			throw new ScoreInputException("0~100 사이 범위 초과");
		
		}
		
		System.out.println("입력한 점수는 : " + score);

		
	}
	public void startEx5() {
		
		try { 
			ex5(); //ScoreInputException이 던져질 가능성이 있음
		
		}catch(ScoreInputException e) {
			
			//e.printStackTrace();
			System.out.println("예외 내용: " + e.getMessage());
			
			System.out.println("예외처리 진행");
						
		}finally {
			System.out.println("프로그램 종료");
		}
		
	}
		
	
}


