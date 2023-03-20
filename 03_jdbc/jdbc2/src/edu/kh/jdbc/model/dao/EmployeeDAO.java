package edu.kh.jdbc.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static edu.kh.jdbc.common.JDBCTemplate.*;
import edu.kh.jdbc.model.dto.Employee;

//DAO (Data Access Object) : DB 접근용 객체
public class EmployeeDAO {
	
	//JDBC 구문이 여러 번 작성될 예정
	// ->JDBC 객체 참조 변수가 계속 작성될 예정 (CONNECTION,STATEMENT)
	// 	->필드로 작성하여 재사용
	
	private Statement stmt;  //기본값으로 참조하기 때문에 null로 기본값 // SQL 수행, 결과 반환
	private ResultSet rs;  //  SELECT 수행 결과 저장용 객체
	
	/**전체 사원 조회 SQL 수행 후 결과를 반환하는 메서드
	 * @param conn
	 * @return empList 
	 * @throws SQLException
	 */
	public List<Employee> selectAll(Connection conn) throws SQLException {
		
		//1.결과 저장을 위한 변수/객체 준비
		List<Employee> empList = new ArrayList<>();
		
		try {
			//2.Statement, ReustSet에 객체 대입
			
			//1)SQL 작성
			//사번,이름,부서명,직급명,전화번호
			  //직급코드 오름차순
			String sql = "SELECT EMP_ID,EMP_NAME,NVL(DEPT_TITLE,'없음') DEPT_TITLE,JOB_NAME,NVL(PHONE,'없음')PHONE	"
							+ "FROM EMPLOYEE \r\n"
							+ "NATURAL JOIN JOB\r\n"
							+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE= DEPT_ID)\r\n"
							+ "ORDER BY JOB_CODE";
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			//3. 조회 결과 1행씩 접근하여 컬럼값을 얻어와 List에 담기
			while(rs.next()) {
				
				String empId  = rs.getString("EMP_ID");
				String empName  = rs.getString("EMP_Name");
				String department  = rs.getString(3);
				String jobName  = rs.getString("JOB_NAME");
				String phone  = rs.getString(5);
				
				Employee emp = new Employee (Integer.parseInt(empId),empName,phone,department,jobName);
						
				empList.add(emp);  //리스트 추가
				

			}
			
		} finally {

			//catch문 -> throws구문으로 예외 처리
			
			// 4.JDBC 객체 지원 자원 반환 (단, conn 빼고)
			close(stmt);
			close(rs);
			
		}
		
		return empList;
		}
	
	
	/**사원 1명 조회
	 * @param input
	 * @return
	 */
	public Employee selectOne(Connection conn,int input) throws SQLException {
		
			//1.결과 저장을 위한 변수/객체 준비
		Employee emp = null;
		//-조회 결과가 있을 경우 객체 생성
		
		try {
			
			//2. SQL 작성 후 수행
			
			String sql = "SELECT EMP_ID,EMP_NAME,NVL(DEPT_TITLE,'없음') DEPT_TITLE,JOB_NAME,NVL(PHONE,'없음')PHONE	"
					+ "FROM EMPLOYEE \r\n"
					+ "NATURAL JOIN JOB\r\n"
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE= DEPT_ID)\r\n"
					+ "WHERE EMP_ID = " + input ;
			
/*수행하는거*/	stmt =conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			//3. 조회 결과가 있는지 확인 후 
			//있으면 Employee 객체 생성 후 emp에 대입
			
/*반복 안 함*/	if(rs.next()){  //rs.next의미? 문자열 받는 입력 받는거 
			
				int empId  = rs.getInt(1);
				//DB에서 값을 얻어올 때
				//"숫자" (문자열로된 숫자) 형태일 경우
				//getInt()를 작성하면 자동으로 int형변환 진행
				
				
				String empName  = rs.getString(2);
				String department  = rs.getString(3);
				String jobName  = rs.getString(4);
				String phone  = rs.getString(5);
				
				//객체 생성해서 emp에 대입
				emp = new Employee(empId,empName,department,jobName,phone);
			
					}

		//if(조건식) {true이면 수행}          -> 1번 수행
		//while(조건식) {true이면 수행} + 반복  
//		---> 1행만 조회되면 1번 수행
//		---> 불필요한 검사를 진행할 수 있다.
//		---> 1행 조회에서는 if문 권장!
			
		}finally {
			//4.JDBC 객체 자원 반환 (conn 빼고)
			close(rs);
			close(stmt);
			
			
	}
		//5.결과를 반환
		return emp;
		
		
}
	
	/** 글자 포함 이름 조회 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @param input
	 * @return empList
	 * @throws SQLException
	 */
	public List<Employee>  selectName(Connection conn,String input) throws SQLException {
	
		List<Employee> empList = new ArrayList<>();
		
      try {	
			//2. SQL 작성 후 수행
			String sql = "SELECT EMP_ID,EMP_NAME,NVL(DEPT_TITLE,'없음') DEPT_TITLE,JOB_NAME,NVL(PHONE,'없음')PHONE	"
					+ "FROM EMPLOYEE \r\n"
					+ "NATURAL JOIN JOB\r\n"
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE= DEPT_ID)\r\n"
					+ "WHERE EMP_NAME Like '%"+input+"%' ORDER BY EMP_ID" ;
			
			stmt =conn.createStatement();
			rs = stmt.executeQuery(sql);
		
	/*if*/	while(rs.next()){ 
				int empId  = rs.getInt(1);
				String empName  = rs.getString(2);
				String department  = rs.getString(3);
				String jobName  = rs.getString(4);
				String phone  = rs.getString(5);
				
				empList.add(new Employee(empId,empName,phone,department,input));
			}
   		}finally {
   			close(rs);
			close(stmt);	
   }
		return empList ;
		
	}


public List<Employee> selectSalary(Connection conn) throws SQLException {
		
		//1.결과 저장을 위한 변수/객체 준비
		List<Employee> empList = new ArrayList<>();
		
		try {
			
			String sql = "SELECT EMP_ID,EMP_NAME,NVL(DEPT_TITLE,'없음') DEPT_TITLE,JOB_NAME,SALARY	"
					     + "FROM EMPLOYEE"
					     + "ORDER BY SALARY DESC";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			

			while(rs.next()) {
				
				String empId  = rs.getString("EMP_ID");
				String empName  = rs.getString("EMP_Name");
				String department  = rs.getString(3);
				String jobName  = rs.getString("JOB_NAME");
				int salary  = rs.getInt(5);
				
				Employee emp = new Employee ();
						
				empList.add(emp);  //리스트 추가
				

			}
			
		} finally {

			close(stmt);
			close(rs);
			
		}
		
		return empList;
		}
	
	
	
	
	
	
	
	
	
	
	
	
}
