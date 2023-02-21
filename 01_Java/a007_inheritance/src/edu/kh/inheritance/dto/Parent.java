package edu.kh.inheritance.dto;

public class Parent {

	private int money = 400_000_000; //돈
	private String lastName = "박"; //성
	
	
	//기본 생성자
	public Parent(){
		System.out.println("Parent() 기본 생성자");
		
	}
	
	//매개 변수 생정사
	public Parent(int money , String lastName) {
	
		this.money = money;
		this.lastName = lastName;
		
		System.out.println("Parent(int,String) 매개변수 생성자");
		
	}
	
	
	//getter/setter
	
	public int getMoney() {
		return money;
		
	}
	
	public void setMoney() {
		this.money = money;
		
	}
	
	public String getLastName() {
		return lastName;
		
	}
	
	public void setlastName(String lastName) {
		this.lastName = lastName;
		
	}
	
	public String toString() {
		return money + "/" + lastName;
		
	}
	
	
	
}
