package edu.kh.jdbc.member.model.service;
import java.sql.Connection;
import java.util.List;
import static edu.kh.jdbc.common.JDBCTemplate.*;

import edu.kh.jdbc.member.model.dao.MemberDAO;
import edu.kh.jdbc.member.model.dto.Member;

public class MemberService {

	private MemberDAO dao = new MemberDAO();

	public List<Member> selectMemberList() throws Exception {
		
		Connection conn = getConnection();
		
		List<Member> memberList =dao.selectMemberList(conn);
		
		
		return null;
	}
	
	
	
}


