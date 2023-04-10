package study.main.model.dao;

import static study.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import study.member.model.dto.Member;


public class MainDAO {
	
	private Statement stmt; //SQL 수행, 결과 반환 //캡슐화 원칙에 의해 private
	private PreparedStatement pstmt; //placeholder를 포함한 SQL세팅/수행 (stmt의 자식)
	private ResultSet rs; //SELECT 수행 결과를 저장
	
	//필드 선언
		private Properties prop;
		
		public MainDAO() {	
			
		try {
			prop = new Properties(); //담을 객체 생성
			prop.loadFromXML(new FileInputStream("main-sql2.xml"));  //자료 불러와서 저장
			//-> Properties 객체에 key:value 형식으로 xml내용이 저장됨
			
			//->prop.getProperty("key") 호출
			//->vlaue (SQL) 반환
			//반환 받는 것도 스트림 형태
		
		}catch(Exception e) {
			e.printStackTrace();
		}
}
		
		/** 로그인
		 * @param conn
		 * @param memberId
		 * @param memberPw
		 * @return member
		 * @throws SQLException
		 */
		public Member login(Connection conn, String memberId, String memberPw) throws SQLException {
			
			Member member = null;
			try {
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int memberNo = rs.getInt("MEMBER_NO");
				String memberName = rs.getString("MEMBER_NM");
				String memberGender = rs.getString("MEMBER_GENDER");
				String enrollDate = rs.getString("ENROLL_DT");
			
			member = new Member();
			
			member.setMemberNo(memberNo);
			member.setMemberId(memberId);
			member.setMemberName(memberName);
			member.setMemberGender(memberGender);
			member.setEnrollDate(enrollDate);
		}
			}finally {
				close(rs);
				close(pstmt);
			}
			return member;
		}
		
	

  	}


