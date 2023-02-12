package edu.kh.control.loop.practice;

import java.util.Scanner;

public class ForPractice {

	public void practice1() {

		Scanner sc = new Scanner(System.in);

		System.out.print("1�댁���� �レ��瑜� ���ν���몄�� : ");
		int input = sc.nextInt();

		if (input >= 1) {
			for (int i = 1; i <= input; i++) {
				System.out.print(i + " ");
			}
		} else {
			System.out.print("1 �댁���� �レ��瑜� ���ν���몄��.");
		}
	}

	public void practice2() {

		Scanner sc = new Scanner(System.in);

		System.out.print("1�댁���� �レ��瑜� ���ν���몄�� : ");
		int input = sc.nextInt();

		if (input >= 1) {
			for (int i = input; i >= 1; i--) {
				System.out.print( i + " ");
			} 
		} else {
			System.out.print("1 �댁���� �レ��瑜� ���ν���몄��.");
		}
	}
	public void practice3() {

		Scanner sc = new Scanner(System.in);

		System.out.print("����瑜� ���� ���ν���몄�� : ");
		int input = sc.nextInt();
		int sum = 0;

		for(int i = 1 ; i <= input ; i++) {
			sum += i; 
		 System.out.print(i);

		 //i == input == 留�吏�留�
		 if(i != input) { //!= 留�吏�留��� ������
			 System.out.print( " + ");
		 }
		}
		System.out.println(" = " + sum);

	}
	public void practice4() {

		Scanner sc = new Scanner(System.in);

		System.out.print("泥� 踰�吏� �レ�� : ");
		int num1 = sc.nextInt();

		System.out.print("�� 踰�吏� �レ�� : ");
		int num2 = sc.nextInt();

		if( num1 >= 1 && num2 >= 1) {	
			for (int i = num1; i <= num2 ; i++) {
			System.out.print(i + " ");


		}} else {
			System.out.println("1�댁���� �レ��瑜� ���ν�댁＜�몄��.");
		}
		}

	public void practice5() {

		Scanner sc = new Scanner(System.in);

		System.out.print("�レ�� : ");
		int dan = sc.nextInt();

		System.out.println("===== " + dan +"�� =====");
			for (int num = 1 ; num  <= 9 ; num ++) {
				System.out.printf("%d * %d = %2d \n", dan, num, dan * num);

			}
		}

	public void practice6() {

		Scanner sc = new Scanner(System.in);

		System.out.println("�レ�� : ");
		int dan = sc.nextInt();

		if (dan >= 2 && dan <= 9) {
			for(int i = dan; i <= 9; i++) {
				System.out.printf("=====  %d�� ===== \n",i);
                for (int num = 1 ; num  <= 9 ; num ++) {
				System.out.printf("%d * %d = %2d \n", i, num, i * num);
			}

		} }else
		System.out.println("2~9 �ъ�� �レ��留� ���ν�댁＜�몄��.");
	}
    public void practice7() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("�������� : ");
        int input = sc.nextInt();
        
        for (int i = 1; i <= input; i++) {
            for (int x = 1; x <= i; x++) {
                System.out.print("*");
            }
            System.out.println();
        }
 }
    
    public void practice8() {
    
        Scanner sc = new Scanner(System.in); 
    
        System.out.print("�������� : ");
        int input = sc.nextInt();
    
        for (int i = input; i >= 1; i--) {
            for (int x = i; x >= 1; x--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    public void practice9() {
        Scanner sc = new Scanner(System.in);
    
        System.out.print("�������� : "); 
        int input = sc.nextInt();
    
        for (int i = 1; i <= input; i++) {
            for (int x = input; x >= i; x--) {
                System.out.print(" ");
            } 
            for (int p = 1; p <= i; p++) {
                System.out.print("*");
                for(int i = dan; i <= 9; i++) {
                    System.out.printf("=====  %d단 ===== \n",i);
                    for (int num = 1 ; num  <= 9 ; num ++) {
                        System.out.printf("%d * %d = %2d \n", i, num, i * num);
                    }
                    System.out.println();
    
                }
            }
            
              
        }
    }
    
    public void practice10() {
        Scanner sc = new Scanner(System.in);
        System.out.print("�������� : ");
        int input = sc.nextInt();
        
        for (int i = 0; i < 5; i++) { // 1~5踰�吏� 以��� �대�뱁���� for臾�
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < 4; i++) { // 6~9踰�吏� 以��� �대�뱁���� for臾�
            for (int j = 0; j < 4 - i; j++) {
                System.out.print("*");
            }
        }            System.out.println();
    }   
    public void practice13() {
        Scanner sc = new Scanner(System.in);
        System.out.print("���곗�� ����瑜� ���ν���몄�� : ");
        int input = sc.nextInt();
        
        int count = 1;
        for (int i = 1; i <= input; i++) {
            if (i % 2 == 0 || i % 3 == 0) {
                System.out.print(i + " ");
            
        } if (i % 2 == 0 && i % 3 == 0)
            count++;
        
    }System.out.println();
    System.out.printf("count: %d", count);  
      
   
}
        
}
    

