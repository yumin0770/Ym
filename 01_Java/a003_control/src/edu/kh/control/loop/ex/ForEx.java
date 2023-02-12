package edu.kh.control.loop.ex;

import java.util.Scanner;

public class ForEx {
	/*
	 * for�� - ���� ������ �ִ� ��쿡 ����ϴ� �ݺ��� (== �ݺ� Ƚ���� �����Ǿ� �ִ� ��� ���)
	 * 
	 * -�ۼ���
	 * 
	 * for(�ʱ��[1]; ���ǽ�[2][5]; ������[4][7]){
	 * 
	 * [3][6]���ǽ��� true�� �� �ݺ� ������ �ڵ� }
	 * 
	 * 1~4 �� ���� �� ���ǽ��� false�� ���� �� ���� 5~7�� �ݺ�
	 * 
	 * - �ʱ�� : for���� �����ϴ� �뵵�� ���� ���� �� �ʱ�ȭ (������ ���� ó�� �����ϴ°� �ʱ�ȭ)
	 * 
	 * - ���ǽ� : for���� �ݺ� ���θ� �����ϴ� �� ���ǽ��� true�� ��쿡�� �ݺ� ������ ��. ���� �ʱ�Ŀ� ���� ������ �̿��༭
	 * ���ǽ��� �ۼ���.
	 * 
	 * - ������ : for���� �� �� �ݺ��� ������ �� ���� �������� Ư�� ���� ���� �Ǵ� ���� ��Ű�� ��
	 * 
	 * ���� �ʱ�Ŀ� ���� ������ ����/���� ���� ���ǽ��� ����� ��ȭ�ϰ� ����� �뵵
	 * 
	 **/

	// for�� ���� ����1
	public void ex1() {

		// 1~10���� �ݺ� ���
		// 1,2,3,4,5,6,7,8,9,10,11 (1���� ����, 1�� ����, 11���� ���߰� ����)

		for (int num = 1; num <= 10; num++) { // �ؼ��� �ʱ��, ������, ���ǽ�
			// num�� 1~10���� 1�� �����ϴ� ����
			System.out.println(num);

		}
	}

	public void ex2() {
		// 5���� 12���� 1�� �����ϸ� ���
		for (int num = 5; num <= 12; num++) {
			System.out.print(num + " ");
		}
	}

	// for�� ���� ���� 3
	public void ex3() {
		// 3���� 20���� 2�� �����ϸ� ���

		for (int i = 3; i <= 20; i += 2) {
			// i = i +2
			System.out.print(i + " ");
		}
	}

	public void ex4() {
		// 1���� 100������ ��� ������ �� == 5,050

		int sum = 0; // i�� �����ϸ鼭 ���� ������ ������ ����
						// 0���� �ʱ�ȭ �ϴ� ���� : � ���� ���ϵ� ������ ���
		for (int i = 1; i <= 100; i++) {

			sum += i; // = sum = i + 1

		}

		System.out.println("�հ� : " + sum);
	}

	// for�� ���� ����5
	public void ex5() {
		// �� ������ �Է� �޾�
		// �� ���� ������ ��� ������ �� ����ϱ�
		// (��, ù ��° �Է� �޴� ������ ������ �۴ٰ� ����)

		// ���� 1 �Է�: 2
		// ���� 2 �Է�: 5
		// 2���� 5���� ��� ������ ��:14

		Scanner sc = new Scanner(System.in);

		System.out.print("���� 1 : ");
		int num1 = sc.nextInt();

		System.out.print("���� 2 : ");
		int num2 = sc.nextInt();

		int sum = 0;
		for (int i = num1; i <= num2; i++) {
			sum += i;

		}
		System.out.printf("%d���� %d���� ��� ������ �� : %d", num1, num2, sum);
	}

	// for�� ���� ����6 //**�ϱ�
	public void ex6() {

		// �ٸ� �ڷ������� for�� ����ϱ�
		// 10���� 20���� 0.5�� �����ϸ� ���
		for (double i = 10; i <= 20; i += 0.5) { // ����ȯ ���Կ����� ��쿡�� ���Կ� ������
			// �ʱ���� int���� �����ϰ� �Ǵ� ��� ���ѷ����� ������ �ȴ�.
			// ��? i += 0.5 ���� �� 10.5�� �ƴ�
			// 10����(int������) ����ȯ�Ǿ� i�� ���ԵǱ� ������

			// �ذ� ��� : �ʱ���� double �ڷ������� ����

			System.out.println(i);

		}

		System.out.println("-------------------------------");
		// A-Z���� ��� ���ĺ� ����ϱ�

		// 1) A, Z�� �����ڵ� ��ȣ �̿��ϱ�(�ƽ�Ű �ڵ�)
		for (int i = 65; i <= 90; i++) {
			System.out.print((char) i);
		}

		// 2) �����ڵ� ��ȣ�� �� ��
		System.out.println();
		for (int i = 'A'; i <= 'Z'; i++) {
			System.out.print((char) i);

		}

		// 3) char �ڷ����� ������������ �����δ� ������ �����Ѵ�!
		System.out.println();
		for (char i = 'A'; i <= 'Z'; i++) {
			System.out.print(i);
		}

	}

	// for�� ���� ����1
	public void ex7() {
		// �����ϱ�
		// 10���� 1���� 1�� �����ϸ� ���
		for (int i = 10; i >= 1; i--) {
			System.out.print(i + " ");
		}

	}

	// for�� ���� ����2
	public void ex8() {
		// �Է�, �հ�, for

		// ���� 5���� �Է� �޾� �հ� ����ϱ�

		Scanner sc = new Scanner(System.in);

		int sum = 0; // �հ踦 ������ ���� ���� �� 0���� �ʱ�ȭ

		for (int i = 1; i <= 5; i++) {// 1���� 5���� 1�� ���� (5ȸ�ݺ�)
			System.out.printf("���� �Է� %d :", i);
			sum += sc.nextInt();

		}

		System.out.print(sum);

	}

	// ex9�� ���� 3
	public void ex9() {

		// ������ �� �� �Է� ������ ���� �Է��ϰ�
		// �Էµ� ������ �հ踦 ����϶�

		// �Է� ���� ������ ���� : 2
		// �Է� 1 : 3
		// �Է� 2 : 5
		// �հ� : 8

		// �Է� ���� ������ ���� : 4
		// �Է� 1: 3
		// �Է� 2: 5
		// �Է� 3 : 1
		// �Է�4 : 2
		// �հ� : 11

		Scanner sc = new Scanner(System.in);

		System.out.printf("�Է� ���� ������ ���� : ");
		int num = sc.nextInt();

		int sum = 0;
		for (int i = 1; i <= num; i++) {
			System.out.printf("�Է� %d :", i);
			sum += sc.nextInt();

		}

		System.out.printf("�հ� : %d ", sum);

	}

	// for�� ���� ���� 4
	public void ex10() {
		// for + if ���� ���

		// 1���� 10���� �ݺ��ϸ� ���
		// ��, ¦���� ��� ()�� ���ڸ� ���μ� ���

		// 1 (2) 3 (4) 5 (6) 7 (8) 9 (10)

		for (int i = 1; i <= 10; i++) {

			// ¦���� ���
			if (i % 2 == 0) {
				System.out.printf("(%d) ", i);
			} else
				System.out.print(i + " ");
		}

	}

	// for�� ���� ���� 5
	public void ex11() {

		// 1���� 10���� 1�� �����ϸ� ���
		// ��, 3�� ����� ��� ���ڸ� [] ���μ� ���
		// ��, 5�� ����� ��� ���� ��� '@' ���

		for (int i = 1; i <= 10; i++) {
			if (i % 3 == 0) { // 3�� ���
				System.out.printf("[%d] ", i);
			} else if (i % 5 == 0) { // 5�� ���
				System.out.print("@ ");
			} else
				System.out.print(i + " ");

		}

	}

	// for�� ���� ���� 6 ������
	public void ex12() {

		// for, if, printf

		// ������ 2�� ����ϱ�
		// 2 x 1= 2
		// 2 x 9 = 18

		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d X %d = %2d \n", 2, i, 2 * i);
		}

	}

	// for�� ���� ���� 7 ������
	public void ex13() {

		// ���ϴ� ���� �Է� �޾Ƽ� �������� ���

		// �� �Է�: 3
		// 3 x 9 =27
		// 3 x 1 = 3

		Scanner sc = new Scanner(System.in);

		System.out.print("�� �Է� : ");
		int num = sc.nextInt();

		for (int i = 9; i >= 1; i--) {
			System.out.printf("%d x %d = %2d \n", num, i, num * i);
		}

	}

	// for�� ���� ���� 8
	public void ex14() {

		// �Է� ���� ���� ������ ����ϱ�
		// ��, �Է� ���� ���� 2~9���̰� �ƴ϶��
		// "�߸� �Է��ϼ̽��ϴ�."���

		Scanner sc = new Scanner(System.in);
		System.out.print("�� �Է� : ");
		int num = sc.nextInt();

		if (num >= 2 && num <= 9) { // ������ ���� ���� (input < 2 || input >9)
			for (int i = 1; i <= 9; i++) {
				System.out.printf("%d x %d = %2d \n", num, i, num * i);
			}
		} else
			System.out.print("�߸� �Է� �ϼ̽��ϴ�.");

	}

	// ��ø �ݺ���
	public void ex15() {

		// 12345 ���޾� ����

		// 1), 2), 3) �ڵ带 �ۼ��ϱ����� ������ ����
		for (int x = 1; x <= 5; x++) { // 3) 4ȸ �ݺ�

			for (int i = 1; i <= 5; i++) { // 1)1234 ���
				System.out.print(i);

			}
			System.out.println(); // 2) �ٹٲ�(����)
		}
	}

	// ��ø �ݺ��� �⺻ ����2
	public void ex16() {

		// 1 2 3 4 5
		// 2 4 6 8 10
		// 3 6 9 12 15
		// 4 8 12 16 20
		// 5 10 15 20 25

		for (int x = 1; x <= 6; x++) {
			for (int i = 1; i <= 5; i++) {
				System.out.printf("%3d", x * i);
			}
			System.out.println();
		}
	}

	// ��ø �ݺ��� ���� ����1
	public void ex17() {
		// �������� 2�� ���� 9�ܱ��� ��� ����ϱ�

		// 2x1 =2 2x2=4 ...

		for (int dan = 2; dan <= 9; dan++) {
			for (int num = 1; num <= 9; num++) {
				System.out.printf("%dx%d=%d ", dan, num, dan * num);

			}
			System.out.println();
		}
	}

	// ��ø �ݺ��� ���� ����1
	public void ex18() {

		// 2�� FOR���� �̿��Ͽ� ���� ����� ����ϼ���.

		// 1
		// 12
		// 123
		// 1234

		for (int x = 1; x <= 4; x++) { // 4�� �ݺ�
			for (int i = 1; i <= x; i++) { // �� �� ���
				System.out.print(i);

			}
			System.out.println();
		}
	}


	// ��ø �ݺ��� ���� ����3
	public void ex19() {
		// 2�� FOR���� �̿��Ͽ� ���� ����� ����ϼ���.
		
		//4
		//43
		//432
		//4321
		
		for (int x = 4; x >= 1; x--) { // 4�� �ݺ� x=4,3,2,1
			for (int i = 4; i >= x; i--) { // �� �� ���
				System.out.print(i);

			}
			System.out.println();
		}
	
	}
	// ��ø �ݺ��� ���� ����4
	public void ex20() {
		//�Էµ� ���� : 3
		//321
		//21
		//1
		
		//�Էµ� ���� : 4
		//4321
		//321
		//21
		//1
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�Էµ� ���� : ");
		int input = sc.nextInt();

		for(int x = input; x >= 1; x-- ) { // 3,2,1
			for(int i = x; i>=1; i-- ) {
				System.out.print(i);
				
			}
			System.out.println();
			
		}
	}
	//ī��Ʈ(���� ����)
	public void ex21() {
		//1���� 20������ 3�� ����� �հ� ������ ���
		//3 6 9 12 15 18
		
		
		//sum : 63
		//count : 6
		
		int sum = 0; //�հ� ����� ����
		int count = 0; //ī��Ʈ�� ����
		
		for(int i= 1; i<=20; i++) {
			if(i % 3 == 0) { //3�� ����� ���
				sum+= i;
				count++;
				
			}
		}
		System.out.println("sum : " + sum);
		System.out.println("count : "+ count);
	}


	//count�� �̿��� ���� for��
		public void ex22() {
			
			// 1  2  3  4
			// 5  6  7  8
			// 9 10 11 12
			
			int count = 1; //���ڸ� �������� ���� ����
			
			for(int row=1 ; row<=3; row++) {//3�� (3��)
				for(int col=1; col <=4; col++) { //4��
				
					System.out.printf("%3d", count++); //count++ �ۿ� �־��µ� ������ ����
					// �������� ī��Ʈ ���ϰ� ����ż� ��ȣ ������ ���� �Ȱ���.
					
					
					
				}
				System.out.println(); //����
				
			}
			
			
			
			
			
		}
	
		
	



}