

package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice3answer {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input1 = sc.nextInt();
		String result1 = input1 == 0 ? "0" :( input1 > 0 ? "양수" : "음수") ;
	    System.out.println(result1 + "입니다");
		
	}

}



/*import java.util.Scanner;

public class OperatorPractice03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input1 = sc.nextInt();
		String result1 = input1 = 0 ? "0" :( input1 > 0 ? "양수" : "음수") ;
	    System.out.println(result1 + "입니다");
		
	*/