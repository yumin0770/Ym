package edu.kh.control.condition.ex;

import java.util.Scanner;

public class SwitchExRunAtHome {

	public static void main(String[] args) {
		SwitchExAtHome seat = new SwitchExAtHome();
		
		

	//	seat.ex1();
	//	seat.ex2();
	//	seat.ex3();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������ ���� ��ȣ �Է� : ");
		int number = sc.nextInt();
		
		switch(number) {
		case 1 : seat.ex1(); break;
		case 2 : seat.ex2(); break;
		case 3 : seat.ex3(); break;
		case 4 : seat.ex4(); break;
		
		default : System.out.println("�������� �ʴ� ���� ��ȣ �Դϴ�.");
	
		}

	}

}
