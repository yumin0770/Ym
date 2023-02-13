package atHome;

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






	}







}