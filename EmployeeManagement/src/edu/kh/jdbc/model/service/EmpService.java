package edu.kh.jdbc.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.close;
import static edu.kh.jdbc.common.JDBCTemplate.commit;
import static edu.kh.jdbc.common.JDBCTemplate.getConnection;
import static edu.kh.jdbc.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import edu.kh.jdbc.model.dao.EmpDAO;
import edu.kh.jdbc.model.dto.Emp;



public class EmpService  {

	private EmpDAO dao = new EmpDAO();

	

	public List<Emp> selectAll() throws SQLException {
		

		Connection conn = getConnection();
		List<Emp> empList =dao.selectAll(conn);
	
		close(conn);
			
		return empList;
	}

	public List<Emp> quitAll() throws SQLException {
		
		Connection conn = getConnection();
			
			List<Emp> empList = dao.quitAll(conn);

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

		public int updateQuit(int input) throws SQLException {

			Connection conn = getConnection();
			
			int result = dao.updateQuit(conn,input);
			
			if(result >0 ) commit(conn);
			else 		rollback(conn);
			
			close(conn);

			
			return result;
		}

		public List<Emp> topFive() throws SQLException {
		
			Connection conn = getConnection();
			
			List<Emp> empList = dao.topFive(conn);
			
			
			close(conn);
			
			
			return empList;
		}

		/**존재하는 사원인지, 퇴직한 사원인지 결과를 반환하는 서비스
		 * @param input
		 * @return check(0:없는 사원 1:퇴직한 사원 2:재직중인 사원)
		 *@throws SQLException
		 */
		public int checkEmployee(int input) throws SQLException {
			
			 Connection conn = getConnection();
			
			 int check = dao.checkEmployee(conn, input);
			 
			 close(conn);
			 
			 return check;

			
			
			

		}

		/**부서별 통꼐 조회 서비스
		 * @return mapList
		 * @throws SQLException
		 */
		public List<Map<String, Object>> selectDepartment()throws SQLException {
			
			Connection conn = getConnection();
			
			List<Map<String,Object>> mapList = dao.selectDepartment(conn);
			
			close(conn);
			
			
		return mapList;
		}





	




	
}
