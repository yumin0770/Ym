package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice04 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 : ");
		int korean = sc.nextInt();
		
		System.out.print("영어 : ");
		int english = sc.nextInt();
		
		System.out.print("수학 : ");
		int math = sc.nextInt();
				
		System.out.println("합격 :" + (korean+english+math) );
		
		System.out.printf("평균 : %.1f \n" , (korean+english+math)/3.0);

		int sum = korean + english + math;
		double avrg = sum/3.0;
		
	  	String result = korean >= 40 && english>= 40 && math >=40 && avrg >=60 ? "합격" : "불합격";
	  	System.out.println(result);
		
}
	}
	
/*package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice4answer {

public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	
	System.out.print("국어 : ");
	int kor = sc.nextInt();   =>영어 짧게 쓰기 korean -> kor
	
	System.out.print("영어 : ");
	int eng = sc.nextInt();
	
	System.out.print("수학 : ");
	int math = sc.nextInt();
			
	int sum = kor + eng + math;
	double avrg = sum/3.0   => avrg약어, 실수 형변환 3.0< ".0";
			

	System.out.println("합격 :" + sum );
	System.out.printf("평균 : " + avrg );

	
	
  	String result = (kor >= 40 && eng>= 40 && math >=40 && avrg >=60) ? "합격" : "불합격";
	System.out.println(result);
 * */



