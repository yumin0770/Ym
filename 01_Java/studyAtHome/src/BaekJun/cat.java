package BaekJun;

import java.util.Scanner;

public class cat {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	
	
	int X = sc.nextInt();
	int N = sc.nextInt();
	
	int sum = 0;
	
	for(int i=0; i<N;  i++) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		 X = X - (a*b);
	}
			if(X == 0){
				System.out.println("yes");
			}else {
				System.out.println("No");
		}
	
 }
}