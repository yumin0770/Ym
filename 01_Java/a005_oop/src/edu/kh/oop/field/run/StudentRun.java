package edu.kh.oop.field.run;

import edu.kh.oop.field.dto.Student;

/*JAVA  실행 단계
 * 
 * 	0.코드 훑어 보기
 * -> static 키워드 찾음
 * -> 찾은 static 키워드가 포함된 필드/변수/메서드를
 * 		static 메모리 영역(정적 메모리 영역)에 생성/추가함
 * 
 * --> static 영역에 추가 시
 * 	  클래스명.필드명
 *    클래스명.메서드명으로 기록된다.
 * 
 * 1.main 실행
 * 
 * 
 * */

public class StudentRun {

	public static void main(String[] args) {
		
		//Student 객체 생성
		Student s1 = new Student();
		s1.name = "김삼순";
		s1.grade = 5;

		Student s2 = new Student();
		s2.name = "박철수";
		s2.grade = 2;
		
		System.out.println("s1 학생 정보");
		System.out.println(s1.name);
		System.out.println(s1.grade);
		System.out.println(s1.schoolName);

		System.out.println("----------------");
		
		System.out.println("s2 학생 정보");
		System.out.println(s2.name);
		System.out.println(s2.grade);
		System.out.println(s2.schoolName);
		
		//학교 이름 변경 
		s1.schoolName = "KH국민학교";
//		s2.schoolName = "KH국민학교";
//	static의 효과 때문에 sc.1만 국민학교로 바뀌었는데 s2도 국민으로 바뀜
		
		/* 참조 변수를 이용해서 static으로 지정된 필드 값을
		* 바굴 수 있지만
		* <클래스명.필드명>을 이용해서 다루는 것을 권장.
		*/
		// 클래스명.필드명 -> static이 붙은건 클래스명.필드명 권장
		Student.schoolName = "KH중학교";
		
//		s1.schoolName = "KH국민학교"; < Student.schoolName = "KH중학교";  -> 권장함
		
		System.out.println("----------------");
		System.out.println("s1 학교명 : " + s1.schoolName);
		System.out.println("s2 학교명 : " + s2.schoolName);

		
		//고정된 값 필요할 때
		//public static final
		// : 어디서든 공유할 수 있는 상수
		System.out.println(Math.PI);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
	}
}




