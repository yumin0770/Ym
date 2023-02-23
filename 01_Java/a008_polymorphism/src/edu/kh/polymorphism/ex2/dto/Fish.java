package edu.kh.polymorphism.ex2.dto;

public class Fish extends Animal {

	//필드
	private int fin;

	
	//생성자
	public Fish() {}


	//매개변수 alt+shift+s+o
	
	public Fish(String tyep, String eatType, int fin) {
		super(tyep, eatType);
		this.fin = fin;
	}

	//getter/setter
	public int getFin() {
		return fin;
	}


	public void setFin(int fin) {
		this.fin = fin;
	}


	@Override
	public String toString() {
		return super.toString() + " / " +fin;

		
	}

	//상속받은 추상 메서드 오버라이딩 강제화
	@Override
	public void breath() {
		System.out.println("아가미 호흡을 한다.");
	}
	
	
	
	
}
