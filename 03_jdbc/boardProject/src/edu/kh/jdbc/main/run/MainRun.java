package edu.kh.jdbc.main.run;

import edu.kh.jdbc.main.view.MainView;

public class MainRun {

	public static void main(String[] args) {
		
	
	
	// 객체를 1회만 사용할 때
	new MainView().mainMenu(); //참조 안 하면 그냥 메인메뉴 불러와서 끝남(1회용)
	//MainView mainMenu = new MainView

	}
}
