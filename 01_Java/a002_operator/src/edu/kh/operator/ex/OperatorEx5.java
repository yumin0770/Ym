package edu.kh.operator.ex;



public class OperatorEx5 {

	public static void main(String[] args) {
		
		//복합 대입 연산자: += -= *= /= %= (등호는 무조건 오른쪽)
		//- 기존 변수에 저장된 값과 새로 대입되는 값의 산술연산
		//- +=(누적) -=(차감)
		
		int a = 10;
		
		a++; //a = a + 1 (a 1씩 증가)
		System.out.println("a를 1 증가 : " +a); //11
		
		a += 4; // a = a + 4 
		System.out.println("a를 4 증가 : " + a); //15
	
		a -=10; // a = a - 10;
		System.out.println("a를 10 차감 : " +a);  //5
		
		a *=3; // a = a *3;
		System.out.println("a를 3배 증가 : " + a);//15
		
		a /=6; // a = a /6;
		System.out.println("a를 6으로 나눴을 때 몫 : " + a); // 2
		
		a %= 2; // a = a % 2;
		System.out.println("a를 2로 나눴을 때 나머지 : " +a); //0
	
	}
	
}
