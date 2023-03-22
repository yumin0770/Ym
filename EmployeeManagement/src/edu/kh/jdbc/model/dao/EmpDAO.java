package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.model.dto.Emp;



public class EmpDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	
	/**
	 * @return
	 */
	public List<Emp> selectAll(Connection conn) throws SQLException {

		List<Emp> empList = new ArrayList<>();
		try {
		
			String sql = " SELECT EMP_ID,EMP_NAME,DEPT_TITLE,JOB_NAME,PHONE,EMAIL\r\n"
				+ " FROM EMPLOYEE \r\n"
				+ " JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
				+ " JOIN JOB USING (JOB_CODE)\r\n"
				+ " WHERE ENT_YN = 'N'\r\n"
				+ "ORDER BY JOB_CODE" ; 
		
		pstmt =conn.prepareStatement(sql);
		rs = pstmt.executeQuery(); 
		
	
			while(rs.next()) {
				
				int empId  = rs.getInt(1);
				String empName  = rs.getString(2);
				String departmentTitle = rs.getString(3);
				String jobName  = rs.getString(4);
				String phone  = rs.getString(5);
				String email  = rs.getString(6);
				
				
				Emp emp = new Emp ();
				emp.setEmpId(empId);
				emp.setEmpName(empName);
				emp.setDepartmentTitle(departmentTitle);
				emp.setJobName(jobName);
				emp.setPhone(phone);
				emp.setEmail(email);
			
					

				empList.add(emp);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return empList;
	}

	public List<Emp> quitAll(Connection conn) throws SQLException {
		
		List<Emp> empList = new ArrayList<>();
		try {
		
			String sql = "SELECT EMP_ID,EMP_NAME,PHONE,EMAIL,ENT_DATE\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "WHERE ENT_YN = 'Y'\r\n"
					+ "ORDER BY ENT_DATE" ; 
		
			pstmt =conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); 

			while(rs.next()) {
				
				int empId  = rs.getInt(1);
				String empName  = rs.getString(2);
				String phone  = rs.getString(3);
				String email  = rs.getString(4);
				String entDate = rs.getString(5);
			
				Emp emp = new Emp ();
				emp.setEmpId(empId);
				emp.setEmpName(empName);
				emp.setPhone(phone);
				emp.setEmail(email);
				emp.setEntYN(entDate);

				empList.add(emp);
	     	}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}



	public Emp selectOne(Connection conn, int input) throws SQLException {
		
		Emp emp = null;
		
		try {
		String sql = "SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, PHONE,EMAIL,HIRE_DATE,ENT_YN\r\n"
				+ "FROM EMPLOYEE \r\n"
				+ " JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
				+ "JOIN JOB USING (JOB_CODE)\r\n"
				+ "WHERE EMP_ID = ? ";
		
		pstmt = conn.prepareStatement(sql);	
		pstmt.setInt(1,input);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			
			int empId = rs.getInt(1);
			String empName = rs.getString(2);
			String departmentTitle = rs.getString(3);
			int salary = rs.getInt(4);
			String phone = rs.getString(5);
			String email = rs.getString(6);
			String hireDate = rs.getString(7);
			String entYN = rs.getString(8);
			
			emp = new Emp(empId,empName,departmentTitle,salary,phone,email,hireDate,entYN);
			
		}
		}finally {
			close(stmt);

		}
		return emp;
	}





	public int insertOne(Connection conn, Emp emp) throws SQLException {
		
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
		pstmt.setString(2,emp.getPhone());
		pstmt.setInt(3,emp.getSalary());
		pstmt.setDouble(4,emp.getBonus());
		pstmt.setInt(5,emp.getEmpId());
		
		result= pstmt.executeUpdate();
		
		}finally{
			
			close(stmt);
			
		}
		
		return result;
	}


	public int deleteOne(Connection conn, int empNo) throws SQLException {

		int result = 0;
		
	try {	
		String sql = "DELETE FROM EMPLOYEE \r\n"
					+ "WHERE EMP_ID = ? ";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,empNo);
		result =pstmt.executeUpdate();				
		
	}finally {
		   close(pstmt);
		}		
		return result;
	}

	public int updateQuit(Connection conn, int input, char answer) throws SQLException {
		
		int result = 0;
		try {
		String sql = "UPDATE EMPLOYEE \r\n"
				+ "SET ENT_YN  = ?\r\n"
				+ "WHERE EMP_ID = ?;";
		
		pstmt =conn.prepareStatement(sql);
		pstmt.setLong(1,answer);
		pstmt.setInt(2,input);
		result =pstmt.executeUpdate();	
		
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public List<Emp> topFive(Connection conn) throws SQLException {
	
		List<Emp> empList = new ArrayList<>();
		
		
		
		String sql = "SELECT ROWNUM,EMP_ID,EMP_NAME,DEPT_TITLE,HIRE_DATE\r\n"
				+ "FROM (SELECT EMP_ID,EMP_NAME,DEPT_TITLE,HIRE_DATE\r\n"
				+ "	FROM EMPLOYEE \r\n"
				+ "	JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
				+ "	ORDER BY HIRE_DATE DESC)\r\n"
				+ "WHERE ROWNUM <=5";
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery(); 
		
		while(rs.next()) {
			
			int empId  = rs.getInt("EMP_ID");
			String empName  = rs.getString("EMP_Name");
			String departmentTitle  = rs.getString("DEPT_TITLE");
			Date hireDate = rs.getDate("HIRE_DATE");
			
			Emp emp = new Emp();
			emp.setEmpId(empId);
			emp.setEmpName(empName);
			emp.setDepartmentTitle(departmentTitle);
			emp.setHireDate(hireDate);
		
				
		empList.add(emp); 
		
		}	
		
		return empList;
	

	}
	
	
	
	
	
	
	
	
	
}






