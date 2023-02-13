package edu.kh.control.condition.ex;

import java.util.Scanner;

public class SwitchExAtHome {

	public void ex1() {

}
	public void ex2() {

		Scanner sc = new Scanner(System.in);

		int random = (int) (Math.random() * 3);
		// 0,1,2 �� �ϳ��� ������ �߻�

		String result;
		switch (random) {
		case 0:
			result = "����";
			break;
		case 1:
			result = "û��";
			break;
		default:
			result = "ȫ��";

		}

		System.out.println(result);

	}
	public void ex3() {

		Scanner sc = new Scanner(System.in);

		// �޴��� �Է� �޾Ƽ� ������ ������ ����ϱ�

		System.out.print("�޴��� �Է��ϼ��� (���/���/������ġ/������): ");

		String input = sc.next();
		
		int price; //������ ������ ���� ����
		
		switch(input) {
		case "김밥" : 	price = 4500; break;
		case "라면" : 	price = 3500; break;
		case "샌드위치" : 	price = 5800; break;
		case "김치찌개" : 	price = 4000; break;
		default : price = -1; //�߸� �Է��� ��쿡 ������� �ʴ� ����(-1)�� �̿��ؼ� ǥ��
		}
		
		 if(price != -1) {
			 System.out.printf("%s�� %d�� �Դϴ�.", input, price);
		 }else { //price�� -1�� ���
			 System.out.println("�������� �ʴ� �޴� �Դϴ�.");
			 
		 }
	}
	
	
	public void ex4 () {
		Scanner sc = new Scanner(System.in);	
		
		
		System.out.print("����1 �Է� : ");
		int num1 = sc.nextInt();
		
		System.out.print("������ �Է� : ");
		String op = sc.next();
		
		System.out.print("����2 �Է� : ");
		int num2 = sc.nextInt();
		
		
		switch(op) {
		case "+" : System.out.printf("%d %s %d = %.3f" , num1,op,num2, (double)num1 + num2); break;
		case "-" : System.out.printf("%d %s %d = %.3f" , num1,op,num2, (double)num1 - num2); break;
		case "*" : System.out.printf("%d %s %d = %.3f" , num1,op,num2, (double)num1 * num2); break;
		case "/" : 
				if(num2 == 0) {
					System.out.println("0���δ� ���� �� �����ϴ�."); break;
				}else {
					System.out.printf("%d / %d = %.3f" , num1,num2, (double)num1 / num2);
		
					System.out.println();break; 
		}
		case "%" : System.out.printf("%s %s %s = %.3f" , num1,op,num2, (double)num1 % num2); break;
		default	: System.out.println("�������� �ʴ� ������ �Դϴ�."); break;
	
	
	
	
	
	
	
	
	
	
	}
	
	}

}
