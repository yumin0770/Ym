package edu.kh.oop.basic;

public class BasicRun {
	
	
	public static void main(String[] args) {
		
		// Java������ Object == Ŭ������ ���ǵ� ������ ����
		//						new �����ڸ� ���� �޸𸮿� �����Ǵ� ��
		
		// ���� ��ü ����
		Nation n1 = new Nation();
		Nation n2 = new Nation();
		Nation n3 = new Nation();
		
		//n1.pNo = "990123-1234567";
		n1.setpNo("990123-1234567(���� ���� �̿�)");
		
		n1.name = "ȫ�浿";
		n1.gender = '��';
		n1.address = "����� �߱� ���빮�� 120";
		n1.phone = "010-1234-1234";
		n1.age = 25;
		
		
		// ��ü�� �Ӽ��� ����� �� ���
//		System.out.println(n1.pNo);
		
		System.out.println( n1.getpNo() );
		
		System.out.println(n1.name);
		System.out.println(n1.gender);
		System.out.println(n1.address);
		System.out.println(n1.phone);
		System.out.println(n1.age);
		
		// ��ü�� ��� ȣ���ϱ�
		n1.medicalBenefits();
		n1.speakKorean();
		
		
	}

}