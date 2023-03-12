package edu.kh.variable;

public class PrintEx {

	public static void main(String[] args) {


		//異��� 硫�����
		
		//System.out.print()
		//-> () ���� �댁�⑹�� 異��� (����怨� 以�諛�轅� X)
		
		//System.out.println()
		//-> () ���� �댁�⑹�� 異��� (����怨� 以�諛�轅� O)
	
		System.out.print(1);
		System.out.print(2);
		System.out.print(3);
		
	
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		
		
		//System.out.printf("�⑦�댁�� �ы�⑤�� 臾몄����", 蹂��� ���� 媛�);
		// ->"�⑦�댁�� �ы�⑤�� 臾몄����" 異��� ��
		// �⑦�� ��由ъ�� �ㅼ�� ���깅�� 蹂��� ���� 媛��� ������濡� ����
		
	
		String name = "��湲몃��";
		int age = 30;
		char gender = 'F';
		
		double height =  185.5;
		
		//��湲몃������ ���� 30�� �� 185.5cm�� �⑥�깆������.
		
		System.out.println(name + "���� ���� " + age + "�� ��" + height +"cm�� " + gender +"�깆������.");
		
		//printf()
		//%s : 臾몄����
		//%d : 10吏� ����
		//%f : �ㅼ�� (湲곕낯 ������ 6��由ш�吏� ����)
		//-> %.1f ������ �� ��由ш�吏� ����
		//-> % 2f ������ �� ��由ш�吏� ����
		//%c : 臾몄���� char
		//%b : �쇰━��
	
		System.out.printf("%s���� ���� %d��, �� %.1fcm�� %c�깆������.", name,age,height,gender);
		
		
		///* printf�� 異��� �� 以��� 諛���吏� ������.
		//�ㅺ껐諛⑸� 1)Systep.out.println(); ����
		System.out.println("hello wordl");
		
		//�닿껐諛⑸� 2) ��異� 遺�(excapse)臾몄��\| \n ����
		
		System.out.println("\nhello \t\t\t world \u0050");
		
		
		
	}

}
