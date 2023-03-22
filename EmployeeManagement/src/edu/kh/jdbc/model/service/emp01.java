import static edu.kh.jdbc.common.JDBCTemplate.close;
import static edu.kh.jdbc.common.JDBCTemplate.commit;
import static edu.kh.jdbc.common.JDBCTemplate.getConnection;
import static edu.kh.jdbc.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.model.dto.Emp;



private void quickAll() {
	System.out.println("\n-----퇴직한 전체 사원 조회-----\n");
	
		try {
			List<Emp> empList = service.quickAll();
			
			if(empList.isEmpty()) {
			System.out.println("[재직중인 사원 입니다.]");
				return;
			}
			for(Emp emp : empList) {
				
				System.out.printf("%d / %s / %s / %s / %s  \n", 
									emp.getEmpId(),
									emp.getEmpName(), 
									emp.getPhone(),
									emp.getEmail(),
									emp.getEntYN());
							      
		}			
		} catch (SQLException e) {
		System.out.println("[사원 조회 중 예외가 발생했습니다.]");
			e.printStackTrace();
		}	
}



public void selectOne() {
	
	System.out.print("[사번이 일치하는 사원 조회] : ");
	int input = sc.nextInt();
	sc.nextLine();
	
	try {
		Emp emp = service.selectOne(input);
		
		if(emp == null ) {
			System.out.println("[일치하는 사번의 사원이 존재하지 않습니다.]");
			return;

		}
		
		System.out.printf("%d /%s /%s /%d /%s /%s / %s / %s \n",
		          emp.getEmpId(),emp.getEmpName(),emp.getDepartmentTitle(),
		          emp.getSalary(),emp.getPhone(),emp.getEmail(),
		          emp.getHireDate(),emp.getEntYN());
		
		
		
	
		} catch (SQLException e) {
		System.out.println("[사원을 조회하던 중 예외가 발생했습니다.]");
		e.printStackTrace();
		
	}

}




private void insertOne() {
		
		System.out.println("[사원 추가]");
		
		 System.out.print("이름 : ");
	     String empName = sc.next();
	     
	     System.out.print("주민등록번호 : ");
	     String empNo = sc.next();
	     
	     System.out.print("이메일 : ");
	     String email = sc.next();
	     
	     System.out.print("전화번호(-제외) : ");
	     String phone = sc.next();
	     
	     System.out.print("부서코드(D1~D9) : ");
	     String deptCode = sc.next();
	     
	     System.out.print("직급코드(J1~J7) : ");
	     String jobCode = sc.next();
	     
	     System.out.print("급여등급(S1~S6) : ");
	     String salLevel = sc.next();
	     
	     System.out.print("급여 : ");
	     int salary = sc.nextInt();
	     
	     System.out.print("보너스 : ");
	     double bonus = sc.nextDouble();
	     
	     System.out.print("사수번호 : ");
	     int managerId = sc.nextInt();
	     sc.nextLine();
		
	     Emp emp = new Emp(empName, empNo, email, phone, salary, deptCode, 
					      jobCode, salLevel, bonus, managerId);
		
	     try {
	 		int result = service.insertOne(emp);
	 		
	 		if(result>0 ) { //성공 시
	 			System.out.println("[삽입 성공!!!]");
	 		
	 		}else {
	 			System.out.println("[삽입 실패...]");
	 		}
	 		
	 		
	 		
	 	} catch (SQLException e) {
	 		System.out.println("\n[사원 정보 삽입 중 예외 발생]\n");

	 		e.printStackTrace();
	 	}
	 }
	
	private void updateOne() {
		
		System.out.println("[사원 정보 수정]");
		
		System.out.print("사원 번호 : ");
		int empId = sc.nextInt();
		
		System.out.print("이메일 수정 : ");
		String email = sc.next();
		
		System.out.print("전화번호 수정 : ");
		String phone = sc.next();
		
		System.out.print("급여 수정 : ");
		int salary = sc.nextInt();
		
		System.out.print("보너스 수청 : ");
		double bonus = sc.nextDouble();
	

		Emp emp = new Emp();
		
		emp.setEmpId(empId);
		emp.setEmail(email);
		emp.setPhone(phone);
		emp.setSalary(salary);
		emp.setBonus(bonus);
	
		
		try {
			int result  = service.updateOne(emp);
	
			if(result>0) {
				System.out.println("수정 성공하였습니다.");
			}else {
				System.out.println("사번이 일치하는 사원이 없습니다.");
			}	
		} catch (SQLException e) {
				System.out.println("사번을 추가하던 중 예외가 발생하였습니다.");
			e.printStackTrace();
		}
		
	}
	
	public void deleteOne() {
		
		System.out.println("[사번으로 사원 정보 삭제]");
		System.out.print("사번 입력 : ");
		int empNo = sc.nextInt();
		
		System.out.print("[정말로 삭제하시겠습니까? Y/N]");
		char answer = sc.next().toUpperCase().charAt(0);
		
			if(answer == 'N') {    //취소할 경우
				System.out.println("취소 되었습니다.");
				return;
			}
			if (answer != 'Y')   {    //취소할 경우,맞는 경우 외는 오류
				System.out.println("잘못 입력하셨습니다");
				return;
			}
			
		   try {
			int result = service.deleteOne(empNo);
			
			String str = null;
			
			if(result> 0) str = "[퇴사 처리가 완료 되었습니다.]";
			else 		  str  = "[사번이 일치하는 사원이 없습니다.]";
			
				System.out.println(str);
			
			
		} catch (SQLException e) {
			System.out.println("삭제 중 예외가 발생했습니다.");
			e.printStackTrace();
		}
		
	}
	
----------------------------------------------------------------------
public List<Emp> quickAll() throws SQLException {
	
Connection conn = getConnection();
	
	List<Emp> empList = dao.quickAll(conn);

	close(conn);
	
	
	
	return empList;
}


public Emp selectOne(int input) throws SQLException {

	
	Connection conn = getConnection();
	
	Emp emp = dao.selectOne(conn,input);
	
	
	close(conn);
	
	
	return emp;
}


public int insertOne(Emp emp) throws SQLException {

	Connection conn = getConnection();
	
	int result = dao.insertOne(conn,emp);

	if(result > 0 ) //삽입 성공 시
		commit(conn);		
	else //삽입 실패시
		rollback(conn);
	close(conn);
	return result;
}



public int updateOne(Emp emp) throws SQLException {
	
	Connection conn = getConnection();
	
	int result = dao.updateOne(conn,emp);
	
	if(result > 0 ) commit(conn);
	else 			rollback(conn);
	
	close(conn);
	
	
	return result;
}



public int deleteOne(int empNo) throws SQLException {

	Connection conn = getConnection();
	
	int result = dao.deleteOne(conn,empNo);

	if(result > 0 ) commit(conn);
	else 			rollback(conn);
	
	close(conn);
		
	return result;
}

------------------------------------------------------------------------
public List<Emp> quickAll(Connection conn) throws SQLException {
	
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
		// TODO Auto-generated catch block
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


