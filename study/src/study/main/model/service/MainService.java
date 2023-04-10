package study.main.model.service;

import static study.common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.SQLException;

import study.main.model.dao.MainDAO;
import study.member.model.dto.Member;

public class MainService {

	private MainDAO dao = new MainDAO();
	
	public Member login(String memberId, String memberPw) throws SQLException {
		
		Connection conn = getConnection();
		
		Member member = dao.login(conn,memberId,memberPw);
		
		return member ;
	}

}
