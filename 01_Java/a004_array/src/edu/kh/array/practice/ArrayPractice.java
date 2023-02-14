package edu.kh.array.practice;

import java.util.Scanner;

public class ArrayPractice {

	public void ex1(){
		
		int[] arr = new int[10];
		
		
		int sum = 0;
	
		for(int i=1; i<arr.length; i++) {
			System.out.print(i + " ");
								
			if(i%2!=0) {
				sum+=i;
				
			}
			

			} System.out.println();
		System.out.printf("짝수 번째 인덱스 합 : %d",sum);
		
		}	
			
	public void ex2() {
		
		int[] arr = new int [10];
		
		int sum = 0;
		
		for(int i=arr.length-1; i>0; i--) {
			System.out.print(i+ " ");
						
			if(i%2==0) {
				sum+=i;
				
			}
	
	
			} System.out.println();
		System.out.printf("홀수 번째 인덱스 합 : %d",sum);
		
		
		
	}
	public void ex3() {
		Scanner sc = new Scanner(System.in);
		
	System.out.print("양의 정수 : ");
	int input = sc.nextInt();
	
	int[] numberArr = new int[input];
	
	for(int i=1; i<= numberArr.length ;i++) {
	
	
		System.out.print(i + " ");
	}
	
	}
	public void ex4() {
		Scanner sc = new Scanner(System.in);
		

	
	
		
		for(int i=0; i<5;i++) {
			System.out.printf("입력 %d: ", i);
			int input = sc.nextInt();
			int[] numbers = new int [input];
			
		
			int index = 0;     
			boolean flag = true; 
			
			for(int f=0; f<numbers.length-1; f++) {
				
				if(input==numbers[f]) 
					index = f;
					flag = false;
					break; 
				
			}
				if(flag) {
					System.out.println("존재하지 않습니다.");
				}else{
					System.out.println(index);
				}
			
	}
			
		



		
	}
	public void ex5() {
		
	}
	public void ex6() {
		
	}
	public void ex7() {
		
	}
	public void ex8() {
		
	}
	public void ex9() {
		
	}
	public void ex10() {
		
	}
	public void ex12() {
		
	}
	public void ex13() {
		
	}
	public void ex14() {
		
	}
	public void ex15() {
		
	}
	public void ex16() {
		
	}
	public void ex17() {
		
	}
	public void ex18() {
		
	}
	public void ex19() {
		
	}
	public void ex20() {
		
	}
	public void ex21() {
		
	}
	public void ex22() {
		
	}
	public void ex23() {
		
	}
	public void ex24() {
		
	}
}
