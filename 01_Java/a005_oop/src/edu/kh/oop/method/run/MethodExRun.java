package edu.kh.oop.method.run;

import edu.kh.oop.method.view.MethodExView;  //패키지가 다를 때 import 체크

public class MethodExRun {

	public static void main(String[] args) {


		//MethodExView 객체 생성 -> new를 이용해서 메모리를 할당하라!
		MethodExView view = new MethodExView(); //기본 생성자
							
		
		//생성자 미작성 시 : 컴파일러가 자동으로 기본 생성자를 추가
		
		view.displayMenu();
		//view가 참조하는 객체
		//.(점 연산자): 참조하는 객체의 필드/메서드에 접근
		
	 						
	}

}
