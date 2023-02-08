package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String Name = sc.next();
		
		System.out.print("학년 : ");
		int grade1 = sc.nextInt();
		
		System.out.print("반 : ");
		int classNumber = sc.nextInt();
		
		System.out.print("번호 : ");
		int studentNumber = sc.nextInt();

		System.out.print("성별 : ");
		String gender = sc.next();
	
		System.out.print("성적 : ");
		double grade2 = sc.nextDouble();

		System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f점 입니다.",grade1,classNumber,studentNumber,Name,gender,grade2);
	}

}
