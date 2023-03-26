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

	

	/**전체 사원 조회
	 * @return empList
	 * @throws SQLException
	 */public List<Emp> selectAll() throws SQLException {
		
		 Connection conn = getConnection();
		 
		 List<Emp> empList = dao.selectAll(conn);
		 
		 close(conn);
		 
			return empList;
		}
	
	
	/**전체 퇴직한 사원 조회
	 * @return
	 * @throws SQLException
	 */
	public List<Emp> quitAll() throws SQLException {
		
		Connection conn = getConnection();
		
		List<Emp> empList = dao.quitAll(conn);
		
		close(conn);
		
		return empList;
	}

		/**3. 사번이 일치하는 사원 조회
		 * @param input
		 * @return
		 * @throws SQLException
		 */
		public Emp selectOne(int input) throws SQLException{
		
		Connection conn = getConnection();
	
		Emp emp = dao.selectOne(conn,input);
	
		close(conn);
		
		return emp;
	}


		/**4.사원정보 삽입
		 * @param emp
		 * @return
		 * @throws SQLException
		 */	public int insertOne(Emp emp) throws SQLException {

				Connection conn = getConnection();
				
				int result = dao.insertOne(conn,emp);

				if(result > 0 ) commit(conn);		
				else 			rollback(conn);
				close(conn);
				return result;
			}



		/**5.회원 정보 수정
		 * @param emp
		 * @return result
		 * @throws SQLException
		 */
		public int updateOne(Emp emp) throws SQLException {
			
			Connection conn = getConnection();
			
			int result = dao.updateOne(conn,emp);
			
			if(result > 0 ) commit(conn);
			else 			rollback(conn);
			
			close(conn);
			
			
			return result;
		}
		
		


		

		/**6.사원 삭제 delete
		 * @param input
		 * @return result
		 * @throws SQLException
		 */
		public int deleteOne(int input) throws SQLException {
	
		Connection conn = getConnection();
		
		int result = dao.deleteOne(conn,input);
		
		if(result>0) commit(conn);
		else  		rollback(conn);
		
		
		close(conn);
			
			return result;
		}
		
		
		
		/**7.사번을 입력받아 퇴사 처리
		 * @param input
		 * @return result
		 * @throws SQLException
		 */
		public int updateQuit(int input) throws SQLException {
			
			Connection conn = getConnection();
			
			int result = dao.updateQuit(conn,input);
			
			if(result>0 ) commit(conn);
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
