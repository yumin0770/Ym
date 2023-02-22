package edu.kh.control.loop.atHome;

import java.util.Scanner;

public class ForPracticeAtHome {

	
	 public void practice8() {
		 
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.print("정수입력 : ");
		 int input = sc.nextInt();
		 
		 for(int i=input; i>=1; i--){
			 for(int j=i; j>=1; j--) {
				System.out.println("*");
			 }
			 
		 } System.out.println();
	 }
	 


	 public void practice9() {
	
	Scanner sc = new Scanner(System.in);
		 
		 System.out.print("정수입력 : ");
		 int input = sc.nextInt();
		 
		 for(int i=1; i<=input; i++){
			 for(int j=1; j<=(input-i); j++) {
				System.out.print(" ");
			 }
		 
			 for(int j=1; j<=i; j++) {
				 System.out.print("*");
			 }
			 System.out.println();
		 	}	
		}
	 
	  
}