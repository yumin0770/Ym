package edu.kh.objectarray.dto;

//data transter object 값을 전달하는 클래스
public class Student {

	//필드  - private=> 캡슐화 원칙에 의해 모두 private - 아무도 못 씀
	private int grade; //학년
	private int classRoom; //반
	private int number; //번호
	private String name; //이름
	
	private int kor; //국어점수
	private int eng; //영어점수
	private int math; //수학 점수
	
	
	//생성자
	
	public Student() {} //기본생성자
	
	//매개변수 (오버로딩 적용-이름이 같으면 안 되는데 같음. 다른 값을 넣어서 적용)(기능의 일종, 객체를 만드는 기능) 
	
	public Student(int grade, int classRoom, int number, String name ) {
		
		//this 참조변수
		this.grade = grade;
		this.classRoom = classRoom;
		this.number = number;
		this.name = name;
		
	}
	
	//getter  /setter
	
	public int getGrade() {
		return grade;

	}
	
	public  void setGrade(int grade) {
		this.grade = grade; //외부에서 가져온 값을 여기에 있는 필드에 대입하겠는 의미
		
	}
	public int getClassroom() {
		return classRoom;

	}
	
	public  void setClassroom(int classRoom) {
		this.classRoom = classRoom; 
		
	}
	
	public int getNumber() {
		return number;

	}
	
	public  void setNumber(int number) {
		this.number = number; 
		
	}
	
	public String getName() {
		return name;

	}
	
	public  void setName(String name) {
		this.name = name; 
		
	}
	
	public int getKor() {
		return kor;

	}
	
	public  void setKor(int kor) {
		this.kor = kor; 
		
	}
	
	public int getEng() {
		return eng;

	}
	
	public  void setEng(int eng) {
		this.eng = eng; 
		
	}
	public int getMath() {
		return math;

	}
	
	public  void setMath(int math) {
		this.math = math; 
		
	}
	
	//객체의 필드 값을 하나의 문자열 형태로 반환하는 메서드 
	//자바에서 String은 클래스 , format은 static
	public String toString() {
		return String.format("%d학년 %d반 %d번 %s [%d, %d, %d,]",
				grade, classRoom, number, name, kor, eng, math );
			
		
	}
	
	
}
