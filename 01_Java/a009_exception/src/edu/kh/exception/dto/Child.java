package edu.kh.exception.dto;

import java.io.IOException;

public class Child extends Parent {

	@Override
	public void test() throws IOException {
		//오버라이딩 시 예외처리 
		
		System.out.println("자식 test()");
	}

}
