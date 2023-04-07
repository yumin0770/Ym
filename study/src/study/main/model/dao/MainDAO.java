package study.main.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import study.member.model.dto.Member;

public class MainDAO {
	
	private Statement stmt; //SQL 수행, 결과 반환 //캡슐화 원칙에 의해 private
	private PreparedStatement pstmt; //placeholder를 포함한 SQL세팅/수행 (stmt의 자식)
	private ResultSet rs; //SELECT 수행 결과를 저장
	
	//필드 선언
		private Properties prop;
		
		try {
			prop = new Properties(); //담을 객체 생성
			prop.loadFromXML(new FileInputStream("main-sql.xml"));  //자료 불러와서 저장
			//-> Properties 객체에 key:value 형식으로 xml내용이 저장됨
			
			//->prop.getProperty("key") 호출
			//->vlaue (SQL) 반환
			//반환 받는 것도 스트림 형태
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
	public Member login(Connection conn, String memberId, String memberPw) {
		
		Member member = null;
		
		
		
		return null;
	}

}
