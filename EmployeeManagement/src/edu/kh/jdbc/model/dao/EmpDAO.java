package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import edu.kh.jdbc.model.dto.Emp;



public class EmpDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	
	/** 재직중인 전체 사원 조회
	 * @param conn
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectAll(Connection conn) throws SQLException {
	
		List<Emp> empList = new ArrayList<>();
		
		try {
		String sql = "SELECT EMP_ID,EMP_NAME,DEPT_TITLE,JOB_NAME,SALARY, PHONE ,EMAIL \r\n"
				+ "FROM EMPLOYEE \r\n"
				+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
				+ "JOIN JOB USING (JOB_CODE)\r\n"
				+ "WHERE ENT_YN ='N'";
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
		int empId = rs.getInt(1);
		String empName = rs.getString(2);
		String deptTtile = rs.getString(3);
		String jobName = rs.getString(4);
		int salary = rs.getInt(5);
		String phone = rs.getString(6);
		String email = rs.getString(7);
		
		
		Emp emp = new Emp();
		
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		emp.setDepartmentTitle(deptTtile);
		emp.setJobName(jobName);
		emp.setSalary(salary);
		emp.setPhone(phone);
		emp.setEmail(email);
		
		
		empList.add(emp);
		}
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return empList;
	}

	
	


	public List<Emp> quitAll(Connection conn)  throws SQLException{
		
		List<Emp> empList = new ArrayList<> ();
		
		String sql = "SELECT EMP_ID,EMP_NAME,PHONE,ENT_DATE  \r\n"
				+ "FROM EMPLOYEE \r\n"
				+ "WHERE ENT_YN = 'Y'" ;
		try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			int empId = rs.getInt("EMP_ID");
			String empName =  rs.getString("EMP_NAME");
			String phone = rs.getString("PHONE");
			String entDate = rs.getString("ENT_DATE");
			
			Emp emp = new Emp();
			emp.setEmpId(empId);
			emp.setEmpName(empName);
			emp.setPhone(phone);
			emp.setEntDate(entDate);
			
			empList.add(emp);
		}
		}finally {
			close(rs);
			close(pstmt);
		}
		return empList;
	}



	/**3. 사번이 일치하는 사원 조회 //사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일, 입사일, 퇴직여부 조회
	 * @param conn
	 * @param input
	 * @return empList
	 * @throws SQLException
	 */public Emp selectOne(Connection conn, int input) throws SQLException {
		
		Emp emp = null;
		try {
		String sql ="SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY, EMAIL, ENT_DATE, ENT_YN,\r\n"
				+ "NVL(DEPT_TITLE, '없음') DEPT_TITLE, \r\n"
				+ "NVL(PHONE, '없음') PHONE\r\n"
				+ "FROM EMPLOYEE\r\n"
				+ "JOIN JOB USING(JOB_CODE)\r\n"
				+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
				+ "WHERE EMP_ID = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, input);
		rs=pstmt.executeQuery();
		 

	
	if(rs.next()) {
		
		int empId = rs.getInt("EMP_ID");
		String empName = rs.getString("EMP_NAME");
		String deptTitle = rs.getString("DEPT_TITLE");
		String jobName= rs.getString("JOB_NAME");
		int salary = rs.getInt("SALARY");
		String phone = rs.getString("PHONE");
		String email = rs.getString("EMAIL");
		String entDate = rs.getString("ENT_DATE");
		String entYN = rs.getString("ENT_YN");
		
		emp = new Emp ();  //재활용
		
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		emp.setDepartmentTitle(deptTitle);
		emp.setJobName(jobName);
		emp.setSalary(salary);
		emp.setPhone(phone);
		emp.setEmail(email);
		emp.setEntDate(entDate);
		emp.setEntYN(entYN);
	}
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return emp;
	}


	/**4.사원 삽입
	 * @param conn
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */public int insertOne(Connection conn, Emp emp) throws SQLException {

		 int result = 0;
			
			try {
				String sql = "INSERT INTO EMPLOYEE VALUES(SEQ_EMP_ID.NEXTVAL,"
						+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, NULL, 'N')"; 
		
				pstmt =conn.prepareStatement(sql);
				
				pstmt.setString(1,emp.getEmpName());
				pstmt.setString(2,emp.getEmpNo());
				pstmt.setString(3,emp.getEmail());
				pstmt.setString(4,emp.getPhone());
				pstmt.setString(5,emp.getDeptCode());
				pstmt.setString(6,emp.getJobCode());
				pstmt.setString(7,emp.getSalLevel());
				pstmt.setInt(8,emp.getSalary());
				pstmt.setDouble(9,emp.getBonus());
				pstmt.setInt(10,emp.getManagerId());
				
			
			result = pstmt.executeUpdate();
				
			}finally{
				close(pstmt); 	
			}

			return result;
		}
	/**5.사번으로 사원 정보 수정
	 * @param conn
	 * @param emp
	 * @return
	 * @throws SQLException
	 */
	public int updateOne(Connection conn, Emp emp) throws SQLException {

		
		int result = 0;
		
		try {
		String sql = "UPDATE EMPLOYEE \r\n"
				+ "SET EMAIL = ?,\r\n"
				+ "	PHONE = ?,\r\n"
				+ "	SALARY = ?,\r\n"
				+ "	BONUS = ?  \r\n"
				+ "WHERE EMP_ID  = ?";
		
		pstmt=conn.prepareStatement(sql);
	
		pstmt.setString(1,emp.getEmail());
		pstmt.setString(2, emp.getPhone());
		pstmt.setInt(3, emp.getSalary());
		pstmt.setDouble(4,emp.getBonus());
		pstmt.setInt(5,emp.getEmpId());
		
		result = pstmt.executeUpdate();
	
		
		}finally{
			
			close(stmt);
			
		}
		
		return result;
	}


	/**6.사원 삭제 delete
	 * @param conn
	 * @param input
	 * @return result
	 * @throws SQLException
	 */
	public int deleteOne(Connection conn, int input) throws SQLException {
	
		int result = 0;
		try {
		String str = "DELETE FROM EMPLOYEE \r\n"
				+ "WHERE EMP_ID = ?";
		
		pstmt = conn.prepareStatement(str);
		pstmt.setInt(1, input);
		
		result = pstmt.executeUpdate();
				
		
		}finally {
			
			close(pstmt);
			
		}
		
		return result;
	}


	/**7.사번을 입력받아 퇴사처리
	 * @param conn
	 * @param input
	 * @return result
	 * @throws SQLException
	 */
	public int updateQuit(Connection conn, int input) throws SQLException {

		int result = 0;
		
		String sql = "UPDATE EMPLOYEE \r\n"
				+ "SET ENT_YN = 'Y'\r\n"
				+ "WHERE EMP_ID = ?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			
			result =pstmt.executeUpdate();
			
		}finally{
		 close(pstmt);
		}
		
		return result;
	}
	
	
	public List<Emp> topFive(Connection conn) throws SQLException {
	
		List<Emp> empList = new ArrayList<>();
		try {
		String sql = "SELECT *\r\n"
				+ "FROM (SELECT EMP_ID,EMP_NAME,NVL(DEPT_TITLE,'부서없음') DEPT_TITLE,HIRE_DATE\r\n"
				+ "	FROM EMPLOYEE \r\n"
				+ "	JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
				+ "	ORDER BY HIRE_DATE DESC)\r\n"
				+ "WHERE ROWNUM <=5 ";
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery(); 
		
		while(rs.next()) {
			
			int empId  = rs.getInt("EMP_ID");
			String empName  = rs.getString("EMP_NAME");
			String departmentTitle  = rs.getString("DEPT_TITLE");
			Date hireDate = rs.getDate("HIRE_DATE");
			
			Emp emp = new Emp();
			emp.setEmpId(empId);
			emp.setEmpName(empName);
			emp.setDepartmentTitle(departmentTitle);
			emp.setHireDate(hireDate);
		
				
		empList.add(emp); 
		
		}	
	}finally {
		close(pstmt);
	}
		return empList;
	

	}


	/**부서별 통계 조회 SQL 수행 후 결과 반환
	 * @param conn
	 * @return mapList
	 * @throws SQLException
	 */
	public List<Map<String, Object>> selectDepartment(Connection conn) throws SQLException {
		
		//1. 결과 저장용 객체 생성
		List<Map<String, Object>> mapList = new ArrayList<>();
		
		
		try {
			//2.SQL 작성 후 수행
			
			String sql ="SELECT DEPT_CODE,NVL(DEPT_TITLE,'부서없음') DEPT_TITLE, COUNT(*) 인원, FLOOR(AVG(SALARY)) 평균\r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "GROUP BY DEPT_CODE, DEPT_TITLE\r\n"
					+ "ORDER BY DEPT_CODE";
			
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String deptTitle = rs.getString("DEPT_TITLE");
				int count = rs.getInt("인원");
				int avg = rs.getInt("평균");
				
				Map<String,Object> map = new LinkedHashMap<>();
				
				map.put("deptTitle", deptTitle);
				map.put("count", count);
				map.put("avg", avg);
				
				mapList.add(map);
				
			}		
		}finally {
			close(rs);
			close(stmt);
		}
		//5. 결과 반환
		return mapList;
	}


}
