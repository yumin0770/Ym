package edu.kh.jdbc.main.model.service;

import java.sql.Connection;
import static edu.kh.jdbc.common.JDBCTemplate.*;
import edu.kh.jdbc.main.model.dao.MainDAO;
import edu.kh.jdbc.member.model.dto.Member;



public class MainService {
	
	private MainDAO dao = new MainDAO();

	/**로그인 서비스
	 * @param memberId
	 * @param memberPw
	 * @return member
	 * @throws Exception
	 */
	public Member login(String memberId, String memberPw) throws Exception {

		//1.Connection 생성
		Connection conn = getConnection(); //jdbc템플릿에서 외부 값을 읽어오게
		
		//2. DAO 호출
		Member member = dao.login(conn,memberId,memberPw);
	
		
		//3.Connectio 반환
		close(conn);
		
		//4.결과 반환
		return member;
	}
	/**아이디 중복 검사 서비스
	 * @param memberId
	 * @return
	 * @throws Exception
	 */
	public int idDuplicationCheck(String memberId) throws Exception {

		Connection conn  = getConnection();
		
		int result = dao.idDuplicationCheck(conn,memberId);	
		close(conn);

		return result;
	}

	/**회원가입 서비스
	 * @param member
	 * @return
	 * @throws Exception
	 */
	public int signUp(Member member) throws Exception{
		
		Connection conn = getConnection();
		int result = dao.signUp(conn,member); //->insert 수행
		//트랜잭션 처리
		if(result >0) commit(conn); //TCL하려면 conn 커넥션이 필요함! 그래서 commit시 담아줌
		else  		  rollback(conn);
		
		close(conn);
		
		
		
		return result;
	}
	
	

	
}
