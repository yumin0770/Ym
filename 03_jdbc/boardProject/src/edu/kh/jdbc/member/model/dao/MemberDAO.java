package edu.kh.jdbc.member.model.dao;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import static edu.kh.jdbc.common.JDBCTemplate.*;

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
}

