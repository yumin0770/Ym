package edu.kh.jdbc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	private PreparedStatement pstmt;
	//Prepared : 준비된
	//->외부 변수를 SQL에 삽입할 준비가 Statement
	
	//PreparedStatement는 Statement 클래스의 자식 믈래스로
	//SQL 구문에 ? 물음표 기호를 작성해서 
	//SQL에 작성되어지는 리터럴 값을 동적으로 제어하는 기능을 가지고 있다
	
	//(?기호 = placeholder)
	
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


	
/** 급여 범위 조회 SQL 수행 후 결과 반환 메서드
 * @param conn
 * @param max
 * @param min
 * @return empList
 * @throws SQLException
 */
public List<Employee> selectSalary(Connection conn,int min,int max) throws SQLException {
		
		//1.결과 저장을 위한 변수/객체 준비
		List<Employee> empList = new ArrayList<>();
		
		try {
			
			/*
			//띄어쓰기 중요하다!!!!!!!!!!!!!!!!!!
			String sql = "SELECT EMP_ID,EMP_NAME,JOB_NAME,SALARY\r\n"
						+ "FROM EMPLOYEE\r\n"
						+ "JOIN JOB USING (JOB_CODE)\r\n"
						+ "WHERE SALARY BETWEEN "+min+" AND "+max+"\r\n"
						+ "ORDER BY SALARY DESC";
			
			//입력 2개, 조회결과가 n행!(DAO단에서 단을 때 list로 받는다)
			//SQL을 수행하고 결과를 반환 받을 Statement 객체 생성
			stmt = conn.createStatement();
			
			//SQL(SELECT) 수행 후 결과(ResultSet) 반환 받아 저장
			rs = stmt.executeQuery(sql);
			*/
			
			//-----------------------------------------------------------------//
			//**2. PreparedStatement 사용하기**
			
			//SQL작성
			String sql = "SELECT EMP_ID,EMP_NAME,JOB_NAME,SALARY\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "JOIN JOB USING (JOB_CODE)\r\n"
					+ "WHERE SALARY BETWEEN ? AND ?\r\n"
					+ "ORDER BY SALARY DESC";
			//-> 값이 동적으로 추가되는 부분을 ? 기호(placeholder)로 작성
			
			//SQL을 수행하고 결과를 반환 받을 PreparedStatement 객체 생성
			pstmt =  conn.prepareStatement(sql);
			
			//PreparedStatement에 추가된 SQL에 구문에서
			// 미완성된(?) 부분에 알맞은 값을 추가
			
			//pstmt.set자료형 (순서, 값)//-> 순서번째 ?에 값을 세팅//(자료형은 값에 맞게 지정)
			pstmt.setInt(1,min);
			pstmt.setInt(2,max);
			
			//준비가 완료된 preparedStatement를 이용해서 
			//SQL 수행 후 결과 반환 받기
			rs = pstmt.executeQuery(); 
			//-> PreparedStatement 객체 생성 시
			// SQL담겨져 있기 때문에 SQL수행 구문에서 따로 매개변수를 작성하지 않는다!
			
			//여러명이 있을 수도 있어서 다음으로 넘거가는 next이용 하는데 반복할 수 있으니 while씀
			while(rs.next()) {
				
				int empId  = rs.getInt("EMP_ID");
				String empName  = rs.getString("EMP_Name");
				String jobName  = rs.getString("JOB_NAME");
				int salary  = rs.getInt("SALARY");
				
				//Employee 객체 생성해서 커럼 값을 세팅
				//(기본생성자  + setter)
				Employee emp = new Employee ();
					emp.setEmpId(empId);
					emp.setEmpName(empName);
					emp.setJobName(jobName);
					emp.setSalary(salary);
				
						
				empList.add(emp);  //리스트 추가
			}
			
		} finally {

			close(rs);
			close(stmt);
		}
		return empList;
		}


	/**사원 정보를 삽입하는 SQL 수행 후 결과 행 개수 반환하는 메서드
	 * @param conn
	 * @param emp
	 * @return
	 * @throws SQLException
	 */
	public int insertEmployee(Connection conn, Employee emp) throws SQLException {

		//**DML 수행 시 영향을 끼친 행의 개수가 반환된다!!**
		//(삽입된 행의 개수, 수정된 행의 개수, 삭제된 행의 개수)
		//->행의 개수 ==숫자(정수) == int 사용
		
		//1.결과를 저장할 변수/객체 선언
		int result = 0;
		
		try {
			//2.PreparedStatement 객체 생성
			
			String sql = "INSERT INTO EMPLOYEE VALUES(SEQ_EMP_ID.NEXTVAL,"
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, NULL, 'N')"; 
				
			
			//2.PreparedStatement 객체 생성 후 placeholder에 값 세팅
			
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
			
			//3.SQL 수행 후 결과 반환 받기
			//executeQuery() : SELECT 수행 후 ResultSet 반환
			//executeUpdate() : DML 수행 후 결과 행의 개수 반환
			
			result = pstmt.executeUpdate(); 
			
			//SELECT와 다르게 옮겨 담는 과정이 없다!
			
		}finally {
			//4.JDBC 객체 자원 반환
			
			close(pstmt); 
		//->Statement를 close() 하는 메서드 호출
			//(매개변수에 다형성 업캐스팅 적용)
		}
		
		
	//5.결과 반환
	return result;
}


	/*사원 정보를 수정하는 SQL수행 후 결과 행 개수 반환하난 메서드
	 * @param conn
	 * @param emp
	 * @return
	 * @throws SQLException
	 */
	public int updateEmloyee(Connection conn, Employee emp) throws SQLException {
		
		//1.결과 저장용 변수/객체 선언
		int result = 0;
		
		try {
			
		//2.PreparedStatement 생성
			
			
		//2-1)SQL 작성
			
			String sql ="UPDATE EMPLOYEE \r\n"
					+ "SET EMAIL = ?,\r\n"
					+ "	PHONE = ?,\r\n"
					+ "	SALARY = ? \r\n"
					+ "WHERE EMP_ID = ?";
			
			
		//2-2)PreparedStatement 생성 후 placeholder에 값 세팅	
		pstmt =conn.prepareStatement(sql);
		
		//setString이 자동으로 222@kh.or.kr같은거 ''(홑따옴표)인식함
			pstmt.setString(1,emp.getEmail());
			pstmt.setString(2,emp.getPhone());
			pstmt.setInt(3,emp.getSalary());
			pstmt.setInt(4,emp.getEmpId());
			
			
			//set자료형() 으로 ?에 값을 세팅할 때
			//자료형에 맞는 DB 리터럴 표기법으로 변환돼서 세팅된다!
			//setString()->  'hong_gd@naver.com'
			//setInt()   -> 120000
			//setDouble  -> 0.2
			//setDate(순서, java.sql.Date) ->DATE타입
			
			
		//3.수행 후 결과 반환 받기
			result =pstmt.executeUpdate();
								//매개변수 SQL 작성X ..매개변수 넣는건 부모객체! 
		
		}finally {
			//4.JDBC 객체 자원 반환
			close(pstmt);
		}
		
		//5.결과 반환
		return result;
	}


	public List<Employee> updateEmloyee(Connection conn, int input) throws SQLException{
		
		
			List<Employee> empList = new ArrayList<>();
		
		try {
			
			String sql = "SELECT EMP_ID, EMP_NAME, ENT_YN,ENT_DATE\r\n"
							+ "FROM EMPLOYEE \r\n"
							+ "WHERE EMP_ID = " + input ;
			
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


	/**퇴사 처리 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @param input
	 * @return
	 */
	public int retireEmployee(Connection conn, int input) throws SQLException {
		
		//1.
		int result = 0;
		
		try {
				String sql ="UPDATE EMPLOYEE \r\n"
						+ "SET ENT_YN = ?,\r\n"
						+ "	ENT_DATE =SYSDATE "
						+ "WHERE EMP_ID =?";
				
				pstmt =conn.prepareStatement(sql);
					pstmt.setInt(1,input);
					result =pstmt.executeUpdate();				
	   }finally {
		   close(pstmt);
		}		
		return result;
	}


	public int deleteEmployee(Connection conn, int input) throws SQLException {
		
		int result = 0;
		
		try {
			
			String sql ="DELETE FROM EMPLOYEE \r\n"
					   + "WHERE EMP_ID = ? " ;
			
				pstmt =conn.prepareStatement(sql);
				pstmt.setInt(1,input);
				result =pstmt.executeUpdate();				
			
		}finally {
			   close(pstmt);
			}		
			return result;
		}


}
