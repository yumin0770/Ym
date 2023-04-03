package edu.kh.jdbc.main.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.jdbc.member.model.dto.Member;

public class MainDAO {

	//필드
	//jdbc객체 참조 변수
	private Statement stmt; //SQL 수행, 결과 반환 //캡슐화 원칙에 의해 private
	private PreparedStatement pstmt; //placeholder를 포함한 SQL세팅/수행 (stmt의 자식)
	private ResultSet rs; //SELECT 수행 결과를 저장
	
	//필드 선언
	private Properties prop;
	//-map<String,String> 형태  //이유 xml파일이 map형캥
	// - XML 파일 입/출력 메서드를 제공
	
	public MainDAO() { //기본 생성자
		
		//DAO 객체가 생성될 때 XML 파일을 읽어와 properties 객체에 저장
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
		
	}

	/**
	 * @param conn
	 * @param memberId
	 * @param memberPw
	 * @return
	 */
	public Member login(Connection conn, String memberId, String memberPw) throws Exception {

		//1.결과 저장용 변수 선언/객체 생성
		Member member = null;
		
		try {
			//2.SQL작성 후 수행
			String sql  = prop.getProperty("login");
	
			
			//prepareStatement 객체를 생성하고 SQL를 담아둔다.
			pstmt = conn.prepareStatement(sql); 
			
			//placeholder에 알맞은 값 대입
			pstmt.setString(1,  memberId);
			pstmt.setString(2,  memberPw);
			
			rs = pstmt.executeQuery(); //sql 안 쓴다! //SELECT 수행 후 결과 반환 받기 (RESUTL = rs)
			
			//3.조회 결과를 1행씩 접근해서 얻어오기  //1명씩 나올거라 예상되면 if
			if(rs.next()) {
				int memberNo = rs.getInt("MEMBER_NO");
			//	String memberId = rs.getString("MEMBER_ID");
			//입력 받은 아이디 == 조회한 아이디
			//-> 따로 DB에서 얻어 올 필요가 없다.
				String memberName = rs.getString("MEMBER_NM");
				String memberGender = rs.getString("MEMBER_GENDER");
				String enrollDate = rs.getString("ENROLL_DT");
				
				//MEMBER 객체 생성 후 값 세팅
				
				member = new Member();
				
				member.setMemberNo(memberNo);
				member.setMemberId(memberId);
				member.setMemberName(memberName);
				member.setMemberGender(memberGender);
				member.setEnrollDate(enrollDate);
				
			}
					
			
		}finally {
			//4.사용한 
			
			close(rs);
			close(pstmt);
			
			
		}
		
		//결과 반환
		return member;
	}

	/** 아이디 중복 검사 SQL 수행
	 * @param conn
	 * @param memberId
	 * @return
	 * @throws Exception
	 */
	public int idDuplicationCheck(Connection conn, String memberId) throws Exception{
		
		int result = 0;
		
		 try {
			String sql = prop.getProperty("idDuplicationCheck");
			
			pstmt = conn.prepareStatement(sql);  
			
			pstmt.setString(1,memberId); //placeholder에 값 대입
			
			rs = pstmt.executeQuery();
	
			if(rs.next()) {
			result = rs.getInt(1);

		}
				
		 }finally {
			close(rs);
			close(pstmt);
		 }
		
		return result;
	}

	/**회원 가입 서비스
	 * @param conn
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Connection conn, Member member) throws Exception{
		
			int result = 0;
			
		try {
			String sql = prop.getProperty("signUp");
			
			pstmt = conn.prepareStatement(sql);
			
			//? 플레이스홀더에 값 세팅
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberGender());
			
			//수행 후 결과 반환
			result = pstmt.executeUpdate();
			
		
			
		}finally {	
			close(pstmt);
		}
		
		return result;
	}

	
}
