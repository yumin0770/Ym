package edu.kh.objectarray.dto;

public class Student {

	// �ʵ� (ĸ��ȭ ��Ģ�� ���� ��� private)
	private int grade; // �г�
	private int classRoom; // ��
	private int number; // ��ȣ
	private String name; // �̸�
	
	private int kor; // ���� ����
	private int eng; // ���� ����
	private int math; // ���� ����
	
	
	// ������
	public Student() { } // �⺻ ������
	
	// �Ű����� ������(�����ε� ����)
	public Student(int grade, int classRoom, int number, String name) {
		
		// this �������� 
		this.grade = grade;
		this.classRoom = classRoom;
		this.number = number;
		this.name = name;
	}
	
	
	// getter / setter
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public int getClassRoom() {
		return classRoom;
	}
	
	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getKor () {
		return kor;
	}
	
	public void setKor(int kor) {
		this.kor = kor;
	}
	
	public int getEng () {
		return eng;
	}
	
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public int getMath () {
		return math;
	}
	
	public void setMath(int math) {
		this.math = math;
	}
	
	// ��ü�� �ʵ� ���� �ϳ��� ���ڿ� ���·� ��ȯ�ϴ� �޼���
	public String toString() {
		return String.format("%d�г� %d�� %d�� %s [%d, %d, %d]", 
						grade, classRoom, number, name, kor, eng, math);
	}
	
	
}
