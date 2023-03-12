package edu.kh.api.service;

import edu.kh.api.dto.Student;

public class APIService {

	// API (Application Programming Interface)
	//         ����     ���α׷���     ����
	// -> ���α׷��� �� �̹� ������ �ִ� Ŭ����/���/�����
	//    ����ڰ� ���� ����� �� �ֵ��� �����ϴ� �� 
	
	
	private Student[] studentList = new Student[10];
	
	public APIService() {
		studentList[0] = new Student(1, 1, 1, "�迵��");
		studentList[1] = new Student(2, 3, 4, "ȫ�浿");
		studentList[2] = new Student(3, 5, 12, "�ڹ���");
	}
	
	// alt + shift + j
	/** �л� �߰� ����
	 * @param grade
	 * @param classRoom
	 * @param number
	 * @param name
	 * @return �߰� ���� �� true / ���� �� false 
	 */
	public boolean addStudent(int grade, int classRoom, int number, String name) {

		int index = 0; // ����ִ� index ����
		for(Student s : studentList) {

			if(s == null) break;
			
			boolean check1 = s.getGrade() == grade;
			boolean check2 = s.getClassRoom() == classRoom;
			boolean check3 = s.getNumber() == number;
			boolean check4 = s.getName().equals(name);
			
			// �л� �迭�� �Է� ���� �л��� ���� �Ѵٸ�
			if(check1 && check2 && check3 && check4)
				return false;
			
			index++;
		}
		
		// �л� �迭�� �л��� ���� �� ���
		if(index == studentList.length)  return false;
		
		// ������ index�� �л� �߰�
		studentList[index] = new Student(grade, classRoom, number, name);
		return true;
	}
	
	
	/** �л� �߰� ����2 (equals / hashCode ���)
	 * @param grade
	 * @param classRoom
	 * @param number
	 * @param name
	 * @return �߰� ���� �� true / ���� �� false 
	 */
	public boolean addStudent2(int grade, int classRoom, int number, String name) {
		
		// 1. equals()�� �̿��� ��
		
		// 1) ���� ���� ���� �ӽ� �л� ��ü ����
		Student temp = new Student(grade, classRoom, number, name);
		
		// 2) �л� �迭�� ���� ���� �ϸ鼭 ������ �л��� �ִ��� �˻�
		
		int index = 0;
		for(Student s : studentList) {
			if(s == null) break;
			
			// s�� �����ϴ� �л���
			// temp�� �����ϴ� �л��� 
			// �ʵ� ���� ���� ���(������ ���)
			// if(s.equals(temp))   return false;
			
			System.out.println(s.hashCode());
			System.out.println(temp.hashCode());
			System.out.println("----------------------");
		
			// hashCode()�� ���� == �ʵ尡 ���� == �ߺ��Ǵ� �л��̴�
			if(s.hashCode() == temp.hashCode()) return false;
			
			index++;
		}
		
		// 3) �л� �迭�� �л��� ���� �� ���
		if(index == studentList.length)  return false;
		
		// 4) �ӽ� �л� ��ü�� �л� �迭�� �߰�
		studentList[index] = temp;
		
		return true;
	}
	
	
	/** �л� �迭���� �̸� �˻�
	 * @param input
	 * @return ��ġ�ϴ� �л��� ������ Student[], 
	 * 		   ������ null
	 */
	public Student[] selectName(String input) {
								// �迵��
								// �����,�迵��,�ڹ���

		// String.split(������) : ���ڿ��� �����ڸ� �������� ������
		//						  String[] ���·� ��ȯ

//		String[] names = input.split("/");
		String[] names = input.split(",|/"); //  , �Ǵ� /�� �������� ���� 


		// �˻��� �л��� ������ �迭
		Student[] result = new Student[studentList.length]; 

		int index = 0; // result �迭�� ����� ��ġ�� ������ ����

		for(String n : names) {

			for(Student s : studentList) {
				if(s == null) break;

				// �Է¹��� �̸��̶� �л��� �̸��� ���ٸ�
				if( s.getName().equals(n) ) {

					result[index] = s; // result �迭�� ��ġ�ϴ� �л� ����
					index++;
				}
			}

		}



		// �˻��� �л��� ������ null ��ȯ
		if(index == 0) {
			return null;
		}

		// �˻��� �л��� ������ �˻� ����� ������ �迭 ��ȯ
		return result;
	}


	
	/** ��� �л� �̸��� �ϳ��� ���ڿ��� ��ȯ
	 * @return
	 */
	public String printName() {
		// [�迵��, ȫ�浿, �ڹ���, null, null, null...]
		
		int size = 0;

		// ���� �л��� �� ���ϱ�
		for(Student s : studentList) {
			if(s == null) break;
			size++;
		}
			
		// �̸��� ������ �迭 ����
		String[] names = new String[size];
		
		for(int i=0 ; i<size ; i++) {
			names[i] = studentList[i].getName();
		}
		
		// String.join("������", String[])
		// -> String[]�� ��Ҹ� �ϳ��� ���ڿ��� ��ħ
		//    ��, ��� ���̻��̿� "������" �߰�
		
		// ex) String[] arr = {"aaa", "bbb" ,"ccc"};
		//     String.join("@", arr);
		//      -> "aaa@bbb@ccc"
		
		return String.join("<>", names);
	}
	
	
	
	
	
	
}