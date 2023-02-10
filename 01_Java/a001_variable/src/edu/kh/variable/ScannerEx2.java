package edu.kh.variable;

import java.util.Scanner;

public class ScannerEx2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// sc.next()     : �ㅼ�� ���λ���� �� �⑥�대�� �살�댁��.
		// sc.nextInt()  : �ㅼ�� ���λ���� ����瑜� �살�댁��
		// sc.nextDouble :  �ㅼ�� ���λ���� �ㅼ��瑜� �살�댁��
		
		System.out.print("�대� : ");
		String inputName = sc.next();
		
		System.out.print("���� : ");
		int inputAge = sc.nextInt();
		
		System.out.print("�� : ");
		double inputHeight =  sc.nextDouble();
		

		// ��湲몃������ 25��, �� 174.5cm ������.
		
		System.out.printf("%s���� %d��, �� %.1fcm ������", inputName, inputAge, inputHeight);
		
	
		
		
	}

}
