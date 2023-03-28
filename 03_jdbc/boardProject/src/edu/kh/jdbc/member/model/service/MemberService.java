
package edu.kh.jdbc.member.model.service;
import static edu.kh.jdbc.common.JDBCTemplate.close;
import static edu.kh.jdbc.common.JDBCTemplate.commit;
import static edu.kh.jdbc.common.JDBCTemplate.getConnection;
import static edu.kh.jdbc.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import edu.kh.jdbc.member.model.dao.MemberDAO;
import edu.kh.jdbc.member.model.dto.Member;

public class MemberService {

	private MemberDAO dao = new MemberDAO();

	public List<Member> selectMemberList() throws Exception {
		
		Connection conn = getConnection();
		
		List<Member> memberList =dao.selectMemberList(conn);
		
		
		return null;
	}

	/**회원정보 수정 (이름,성별 수정하기)
	 * @param memberName
	 * @param memberGender
	 * @param memberNo
	 * @return result
	 * @throws SQLException
	 */
	public int updateMember(String memberName, String memberGender, int memberNo) throws Exception {
	
		Connection conn = getConnection(); //jdbc템플릿에서 만들어서 가져옴. 드라이브.xml안에 있는 거
		
		int result = dao.updateMember(conn,memberName,memberGender,memberNo);
		
		if(result>0) commit(conn);
		else 		rollback(conn);
		
		close(conn);
		return result;
	}

	/**회원 비밀번호 수정
	 * @param newPw
	 * @param confirmPw
	 * @param memberNo
	 * @return result
	 * @throws SQLException
	 */
	public int updatePassword(String currentPw,String newPw, int memberNo) throws Exception {
	
		Connection conn = getConnection();
		
		int result = dao.updatePassword(conn,currentPw,newPw,memberNo);
		
		if(result>0) commit(conn);
		else		rollback(conn);
				
		close(conn);
		return result;
	}
	
	//보안코드 뷰말고 서비스 부터 만들기!!!
	
	/**숫자 6자리 보안코드 생성 서비스
	 * @return code
	 */
	public String createSecurityCode() {
		
		StringBuffer code = new StringBuffer();
		
		//String : 불변성
		//StringBuffer : 가변성
		
		Random ran = new Random();//난수 생성객체
		
		for (int i=0; i<6; i++) {
			int x = ran.nextInt(10);  //nextInt(10) ->의미? 0포함 지정된값 제외까지 0이상 10미만 정수
			code.append(x); //StringBuffer 마지막에 추가(뒤에 이어 붙임)
			
		}
		
		return code.toString(); //저장된 내용을 문자열로 바꿔서 반환
		
	}

	/**회원 탈퇴
	 * @param memberPw
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int unResiterMember(int memberNo) throws Exception {
	
		Connection conn = getConnection();
		
		int result = dao.unResiterMember(conn,memberNo);
		
		if(result>0) commit(conn);
		else		rollback(conn);
				
		close(conn);
		
		
	
		return result;
	}
	
	
	
	
}


