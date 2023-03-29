package edu.kh.jdbc.member.model.dao;
import static edu.kh.jdbc.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.common.Session;
import edu.kh.jdbc.member.model.dto.Member;

public class MemberDAO {
	
	//JDBC 객체 참조 변수
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//xml에 작성된 SQL을 읽어와 저장할 객체 참조 변수
	private Properties prop;
	
	
	//ctrl+space
	public MemberDAO(){//기본 생성자로 객체 생성시 xml읽어오기
	
	
	
	try {
		prop= new Properties();
		prop.loadFromXML(new FileInputStream("member-sql.xml"));
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	

	}


	public List<Member> selectMemberList(Connection conn) throws Exception {
		
		List<Member> memList = null;
		
		try {
	
			String sql  = prop.getProperty("selectMemberList");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		
			while(rs.next()) {
				
				String memberId = rs.getString("MEMBER_ID");
				String memberName = rs.getString("MEMBER_NM");
				String memberGender = rs.getString("성별");
				
			 
			Member mem = new Member();
			
			mem.setMemberId(memberId);
			mem.setMemberName(memberName);
			mem.setMemberGender(memberGender);
			
			 memList.add(mem);
				
			}
			
	
		
		}finally {
			close(rs);
			close(pstmt);
		}

	
		
		return memList;
	}

	/**회원 정보 수정
	 * @param conn
	 * @param memberName
	 * @param memberGender
	 * @param memberNo
	 * @return result;
	 * @throws SQLException
	 */
	public int updateMember(Connection conn, String memberName, String memberGender, int memberNo) throws Exception {
		
		//1.결과 저장용 변수 선언 // 안에쓰면 안 담김.
		int result = 0;
		
		try {
		String sql = prop.getProperty("updateMember");
		
		pstmt =conn.prepareStatement(sql);
		
		pstmt.setString(1, memberName);
		pstmt.setString(2, memberGender);
		pstmt.setInt(3, memberNo);
		
		result = pstmt.executeUpdate();
		
		}finally {
			//3.JDBC 객체 자원을 반환
			close(pstmt);
		}
		return result;
	}


	/**회원 비밀번호 변경 서비스
	 * @param conn
	 * @param newPw
	 * @param confirmPw
	 * @param memberNo
	 * @return result
	 * @throws SQLException
	 */
	public int updatePassword(Connection conn,String currentPw, String newPw, int memberNo) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("updateaPassword");
			
			pstmt =conn.prepareStatement(sql);
			
			pstmt.setString(1, newPw);
			pstmt.setString(2, currentPw);
			pstmt.setInt(3, memberNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}	
		return result;
	}


	/**회원 정보 수정
	 * @param conn
	 * @param memberPw
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int unResiterMember(Connection conn, String memberPw, int memberNo) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("unResiterMember");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,memberPw);
			pstmt.setInt(2,memberNo);
			result = pstmt.executeUpdate();
			
			
		}finally {
			
			close(pstmt);
		}
		
	
		return result;
	}
	
	
	
	
	
	
}














