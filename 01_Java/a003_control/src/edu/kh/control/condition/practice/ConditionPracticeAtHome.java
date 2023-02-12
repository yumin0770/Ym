package edu.kh.control.condition.practice;

import java.util.Scanner;

public class ConditionPracticeAtHome {
	
	public void ex1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 한 개 입력하세요 : ");
		int input = sc.nextInt();
	
		
		 	 	
		if(input % 2 == 0 && input >= 1) {
			System.out.print("짝수입니다"); 
		} else if(input % 2 != 0) {
			System.out.print("홀수입니다"); 
		} else {
			System.out.print("양수만 입력해주세요");
		}
	}

	public void ex2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어점수 : ");
		int kor = sc.nextInt();
		
		System.out.print("영어점수 : ");
		int eng = sc.nextInt();
			
		System.out.print("수학점수 : ");
		int math = sc.nextInt();
		
		int sum = kor+eng+math;
		double avg = sum / 3.0;
	
		if(kor>=40 && eng>=40 && math>=40 && avg >=60) {
			System.out.println("국어 : " + kor);
			System.out.println("영어 : " + eng);
			System.out.println("수학 : " + math);
			System.out.println("합계 : " + sum);
			System.out.printf("평균 %.1f \n: " , avg);
			System.out.println("축하합니다,합격입니다");
		}else 
			System.out.println("불합격입니다.");
	
	}
	public void ex3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1~12사이의 정수 입력 : \n");
		int month = sc.nextInt();
		
		
		
		switch(month) {
		case 1 : case 3 : case 5 : case 7 : case 8 : case 10 : case 12 : 
			System.out.printf("%d월은 31일까지 있습니다.", month);break;
		case 4 : case 6 : case 9 : case 11 :  
			System.out.printf("%d월은 30일까지 있습니다.", month);break;
		case 2 :
			System.out.printf("%d월은 28일까지 있습니다.", month);break;
		default : System.out.printf("%d월은 잘못 입력된 달입니다.",month);break;
		
	
		}
	}
		public void ex4() {
			 
			Scanner sc = new Scanner(System.in);
			
			System.out.print("키(m)를 입력해 주세요 : \n");
			double hei = sc.nextDouble();
			
			System.out.print("몸무게(kg)를 입력해 주세요 : \n");
			double wei = sc.nextDouble();
			
			System.out.printf("BMI 지수 : %f \n", (wei / (hei * hei)));
			
			
			double bmires = wei / (hei * hei);
			String result;
			
			if(bmires < 18.5) {
				result = "저체중";
			}else if(bmires >=18.5 && bmires < 23) {
				result = "정상체중";
			}else if(bmires >=23 && bmires <253) {
				result = "과체중";
			}else if(bmires >=25 && bmires < 30) {
				result = "정상체중";
			}else {
				result = "고도 비만";
			}
			System.out.println(result);
			
		} 
		public void ex5() {
			
		Scanner sc = new Scanner(System.in);
		
		System.out.print("중간 고사 점수 : ");
		int med = sc.nextInt();

		System.out.print("기말 고사 점수 : ");
		int fin = sc.nextInt();
		
		System.out.print("과제 횟수 : ");
		int asm = sc.nextInt();

		System.out.print("출석 횟수 : ");
		double atd = sc.nextDouble();
		
		System.out.println("================= 결과 =================");	
		
		double sum = med + fin + asm + atd;
		double medres = med/100.0*20.0 ;
		double finres = fin / 100.0*30.0 ;
		double asmres = asm / 100.0*30.0 ;
		double asmres2 = asm/20.0*100.0;
		double total = medres + finres + asmres + atd;
		
		
		
		if(total >= 70) {
		System.out.printf("중간 고사 점수(20) : %f \n", medres);
		System.out.printf("기말 고사 점수(30) : %f \n", finres);
		System.out.printf("과제 점수(30) : %f \n", asmres);
		System.out.printf("출석 점수(20) : %f \n", atd);
		System.out.printf("총점 : %f \n", total);
		System.out.print("PASS");	
		
		}else if (total < 70 ) {
			System.out.printf("중간 고사 점수(20) : %f \n", medres);
			System.out.printf("기말 고사 점수(30) : %f\n", finres);
			System.out.printf("과제 점수(30) : %f \n", asmres);
			System.out.printf("출석 점수(20) : %f \n", atd);
			System.out.printf("총점 : %f \n", total);
			System.out.print("fail [점수 미달]");
	
		}else if (asmres2>= 30 ) {
			System.out.printf("fail [출석 횟수 부족 %d/%d]",atd,a);
	
			}
	
		}
				

}
		
		

	
	
	
	
	
	
	

