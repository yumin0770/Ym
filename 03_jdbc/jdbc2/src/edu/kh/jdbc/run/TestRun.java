package edu.kh.jdbc.run;

//JDBCTemplate에 존재하는 static 필드/메서드 가져와서 사용
import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import edu.kh.jdbc.common.JDBCTemplate;

public class TestRun {

	public static void main(String[] args) {
	
		//JDBCTemplate 사용 예시
		
		//1.JDBC객체 참조 변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//2단계 : 1단계에서 선언한 참조 변수에 알맞은 객체 대입
			Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드
			
//    		conn = JDBCTemplate.getConnection(); //TDBCTemplate에서 connection 필드 가져오기
			conn = getConnection(); //TDBCTemplate에서 connection 필드 가져오기
			
			
			//SQL 작성 / ** Java에서 작성되는 SQL은 마지막에 세미콜론(;)을 작성하지 않는다! **
			String sql =  "SELECT EMP_ID, EMP_NAME, SALARY FROM EMPLOYEE"; //sql에서 가져올 데이터 적기 select구문
			
			//Statement 객체 생성
			// -> DB에 SQL 전달 후 수행 -> 결과를 반환 받음
			// --> Connection 내부에 생성되어 DB와 통신하는 역할
			stmt = conn.createStatement(); //순방향으로만 데이터를 읽어내려간다
			
			//SQL(select) 수행 후 결과 (ResultSet) 반환
		//	Statement 객체를 통해 SQL(SELECT)을 수행하고
			//    결과(ResultSet)를 반환 받아와서 저장(rs)
			rs=stmt.executeQuery(sql);
			
			
			//3.조회 결과의 행을 반복 접근하며 출력
			while(rs.next()) {   //rs.next() :  커서를 다음 행으로 이동하여 다음 행이 존재하면 true 반환
				
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				int salary = rs.getInt("SALARY");
				
				System.out.printf("%s / %s / %d \n",empId,empName,salary);			
			}
				} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		} //4.사용한 JDBC 객체 자원 반환
//		JDBCTemplate.close(rs);
//		JDBCTemplate.close(stmt);
//		JDBCTemplate.close(conn);

		
		close(rs);
		close(stmt);
		close(conn);
		
		
		
		
		
	}

}
