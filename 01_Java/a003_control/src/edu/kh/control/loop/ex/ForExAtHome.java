package edu.kh.control.loop.ex;

import java.util.Scanner;

public class ForExAtHome {

	// for�� ���� ����5
		public void ex5() {
			// �� ������ �Է� �޾�
			// �� ���� ������ ��� ������ �� ����ϱ�
			// (��, ù ��° �Է� �޴� ������ ������ �۴ٰ� ����)

			// ���� 1 �Է�: 2
			// ���� 2 �Է�: 5
			// 2���� 5���� ��� ������ ��:14
			
			Scanner sc = new Scanner(System.in);
			
			
			System.out.print("���� 1 �Է� : " );
			int num1 = sc.nextInt();
			
			System.out.print("���� 2 �Է� : ");
			int num2 = sc.nextInt();
			
			int sum =0;
			for(int i =2 ; i <= 5 ; i++) {
				sum += i;
			}
			System.out.printf("%d���� %d���� ��� ������ ��: %d",num1,num2,sum );
	
		}
		public void ex10() {
			// for + if ���� ���

			// 1���� 10���� �ݺ��ϸ� ���
			// ��, ¦���� ��� ()�� ���ڸ� ���μ� ���

			// 1 (2) 3 (4) 5 (6) 7 (8) 9 (10)

			for (int i = 1; i <= 10; i++) {
				if(i % 2 == 0) {
					System.out.printf("(%d) " , i);
				} else
					System.out.printf("%d ",i);
	
	
	       }
		}
	
		public void ex11() {

			// 1���� 10���� 1�� �����ϸ� ���
			// ��, 3�� ����� ��� ���ڸ� [] ���μ� ���
			// ��, 5�� ����� ��� ���� ��� '@' ���
		
			for(int i=1; i<=10; i++) {
				if(i % 3 ==0) {
					System.out.printf("[%d] ",i);
				}else if(i % 5 ==0) {
					System.out.printf("@ ",i);
				}else 
					System.out.print(i + " ");
			}
			
		}	
		
		public void ex12() {

			// for, if, printf

			// ������ 2�� ����ϱ�
			// 2 x 1= 2
			// 2 x 9 = 18
		for(int i = 1; i<=9 ; i++) {
			System.out.printf("%d x %d = %d \n",2,i,2*i);
		}
		
	}
		
		public void ex13() {

			// ���ϴ� ���� �Է� �޾Ƽ� �������� ���

			// �� �Է�: 3
			// 3 x 9 =27
			// 3 x 1 = 3
			
		Scanner sc = new Scanner(System.in);
		int dan = sc.nextInt();
		
		for(int i=9 ; i>=1 ; i++) {
			System.out.printf("%d x %d = %d \n",dan,i,dan*i);
		}
	}
		public void ex14() {

			// �Է� ���� ���� ������ ����ϱ�
			// ��, �Է� ���� ���� 2~9���̰� �ƴ϶��
			// "�߸� �Է��ϼ̽��ϴ�."���
			Scanner sc = new Scanner(System.in);
			int dan = sc.nextInt();
			
			if(2<= dan && 9>= dan) {
				for(int i = 1; i<=9 ; i++) {
					System.out.printf("%d x %d = %d \n",dan,i,dan*i);
			}}else 
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			
			
			
		}
		public void ex18() {

			// 2�� FOR���� �̿��Ͽ� ���� ����� ����ϼ���.

			// 1
			// 12
			// 123
			// 1234
		
			for(int x=1 ; x<=4; x++) {
				for (int i =1 ;  i <= x ; i++) {
					System.out.print(i);
				} System.out.println();
			} 
			
	
		}
		
		public void ex19() {
			// 2�� FOR���� �̿��Ͽ� ���� ����� ����ϼ���.
			
			//4
			//43
			//432
			//4321
			
			for(int x =4; x>=1 ; x--) {
				for(int i=4 ; i>=x ; i--) {
					System.out.print(i);
				} System.out.println();
			}
		}
		public void ex20() {
			//�Էµ� ���� : 3
			//321
			//21
			//1
			
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			
			for(int x=input ; x>=1 ; x--) {
				for(int i=x ; i >=1 ; x-- ) {
					System.out.println(i);
				}
			}
		}	
		
		public void ex21() {
				
			int sum =0;
			int count = 0;
			
			for(int i=1;i<=20;i++) {
				if(i % 3==0) {
					sum+=i;
					count++;
				}
			}
			System.out.println("sum : " + sum);
			System.out.println("count : "+ count);
		}
	
		
		
}