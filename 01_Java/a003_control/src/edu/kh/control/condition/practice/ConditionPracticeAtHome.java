package edu.kh.control.condition.practice;

import java.util.Scanner;

public class ConditionPracticeAtHome {
	
	public void ex1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڸ� �� �� �Է��ϼ��� : ");
		int input = sc.nextInt();
	
		
		 	 	
		if(input % 2 == 0 && input >= 1) {
			System.out.print("¦���Դϴ�"); 
		} else if(input % 2 != 0) {
			System.out.print("Ȧ���Դϴ�"); 
		} else {
			System.out.print("����� �Է����ּ���");
		}
	}

	public void ex2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�������� : ");
		int kor = sc.nextInt();
		
		System.out.print("�������� : ");
		int eng = sc.nextInt();
			
		System.out.print("�������� : ");
		int math = sc.nextInt();
		
		int sum = kor+eng+math;
		double avg = sum / 3.0;
	
		if(kor>=40 && eng>=40 && math>=40 && avg >=60) {
			System.out.println("���� : " + kor);
			System.out.println("���� : " + eng);
			System.out.println("���� : " + math);
			System.out.println("�հ� : " + sum);
			System.out.printf("��� %.1f \n: " , avg);
			System.out.println("�����մϴ�,�հ��Դϴ�");
		}else 
			System.out.println("���հ��Դϴ�.");
	
	}
	public void ex3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1~12������ ���� �Է� : \n");
		int month = sc.nextInt();
		
		
		
		switch(month) {
		case 1 : case 3 : case 5 : case 7 : case 8 : case 10 : case 12 : 
			System.out.printf("%d���� 31�ϱ��� �ֽ��ϴ�.", month);break;
		case 4 : case 6 : case 9 : case 11 :  
			System.out.printf("%d���� 30�ϱ��� �ֽ��ϴ�.", month);break;
		case 2 :
			System.out.printf("%d���� 28�ϱ��� �ֽ��ϴ�.", month);break;
		default : System.out.printf("%d���� �߸� �Էµ� ���Դϴ�.",month);break;
		
	
		}
	}
		public void ex4() {
			 
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Ű(m)�� �Է��� �ּ��� : \n");
			double hei = sc.nextDouble();
			
			System.out.print("������(kg)�� �Է��� �ּ��� : \n");
			double wei = sc.nextDouble();
			
			System.out.printf("BMI ���� : %f \n", (wei / (hei * hei)));
			
			
			double bmires = wei / (hei * hei);
			String result;
			
			if(bmires < 18.5) {
				result = "��ü��";
			}else if(bmires >=18.5 && bmires < 23) {
				result = "����ü��";
			}else if(bmires >=23 && bmires <253) {
				result = "��ü��";
			}else if(bmires >=25 && bmires < 30) {
				result = "����ü��";
			}else {
				result = "�� ��";
			}
			System.out.println(result);
			
		} 
		public void ex5() {
			
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�߰� ��� ���� : ");
		int med = sc.nextInt();

		System.out.print("�⸻ ��� ���� : ");
		int fin = sc.nextInt();
		
		System.out.print("���� Ƚ�� : ");
		int asm = sc.nextInt();

		System.out.print("�⼮ Ƚ�� : ");
		double atd = sc.nextDouble();
		
		System.out.println("================= ��� =================");	
		
		double sum = med + fin + asm + atd;
		double medres = med/100.0*20.0 ;
		double finres = fin / 100.0*30.0 ;
		double asmres = asm / 100.0*30.0 ;
		double asmres2 = asm/20.0*100.0;
		double total = medres + finres + asmres + atd;
		
		
		
		if(total >= 70) {
		System.out.printf("�߰� ��� ����(20) : %f \n", medres);
		System.out.printf("�⸻ ��� ����(30) : %f \n", finres);
		System.out.printf("���� ����(30) : %f \n", asmres);
		System.out.printf("�⼮ ����(20) : %f \n", atd);
		System.out.printf("���� : %f \n", total);
		System.out.print("PASS");	
		
		}else if (total < 70 ) {
			System.out.printf("�߰� ��� ����(20) : %f \n", medres);
			System.out.printf("�⸻ ��� ����(30) : %f\n", finres);
			System.out.printf("���� ����(30) : %f \n", asmres);
			System.out.printf("�⼮ ����(20) : %f \n", atd);
			System.out.printf("���� : %f \n", total);
			System.out.print("fail [���� �̴�]");
	
		}else if (asmres2>= 30 ) {
			System.out.printf("fail [�⼮ Ƚ�� ���� %d/%d]",atd,a);
	
			}
	
		}
				

}
		
		

	
	
	
	
	
	
	

