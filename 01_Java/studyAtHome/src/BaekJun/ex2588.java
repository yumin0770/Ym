package BaekJun;

import java.util.Scanner;

public class ex2588 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("A 입력:");
		int A = sc.nextInt();
		System.out.println("B 입력:");
		int B = sc.nextInt();
		
		System.out.println(A*(B % 10));
		System.out.println(A*((B/10)%10-(B%10)/10));
		System.out.println(A*((B/10%100)-(B/10 % 10))/10);
		System.out.println(A*B);
		
		int C = (B % 10) * A;
		int D = ((B % 100)/10)*A;
		int E = (B /100)*A;
		
		
		System.out.println(C);
		System.out.println(D);
		System.out.println(E);
		System.out.println(A*B);
		
	}

}
