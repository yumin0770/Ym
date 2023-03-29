package edu.kh.jdbc.board.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.board.model.dto.Comment;

public class CommentDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;

	public CommentDAO() {

			try {
				prop = new Properties();
				prop.loadFromXML(new FileInputStream("comment-sql.xml"));

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	/**
	 * 댓글 목록 조회 SQL 수행
	 * 
	 * @param conn
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public List<Comment> selectCommentList(Connection conn, int input) throws Exception {

		// 결과 저장용 객체 생성
		List<Comment> commentList = new ArrayList<>();

		try {

			String sql = prop.getProperty("selctCommentList");

			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, input);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				Comment c = new Comment();

				c.setCommentNo(rs.getInt(1));
				c.setCommentContent(rs.getString(2));
				c.setMemberNo(rs.getInt(3));
				c.setMemberName(rs.getString(4));
				c.setCreateDate(rs.getString(5));

				commentList.add(c);

			}

		} finally {

			close(rs);
			close(pstmt);

		}

		return commentList;
	}

	/**댓글 삽입
	 * @param conn
	 * @param commentContent
	 * @param boardNo
	 * @param memberNo
	 * @param commnetNo 
	 * @return result
	 * @throws Exception
	 */
	public int insetBoard(Connection conn, String commentContent, int boardNo, int memberNo, int commentNo) throws Exception{
	
		int result  = 0;
		
		try {
		String sql = prop.getProperty("insetBoard");
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,commentNo);
		pstmt.setString(2,commentContent);
		pstmt.setInt(3,memberNo);
		pstmt.setInt(4,boardNo);
		
		result = pstmt.executeUpdate();
		
		
		}finally {
		
			close(pstmt);
		}
		
		
		return result;
	}

	public int nextCommentNumber(Connection conn) throws SQLException {
		
		int commnetNo = 0;
		
		try {
			String sql = prop.getProperty("nextCommentNo");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
			commnetNo = rs.getInt(1);
			}	
			
		}finally {
			close(rs);
			close(stmt);	
		}
		return commnetNo;
	
	}

	public int updateComment(Connection conn, int commentNo, String commentContent) throws SQLException {
	
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateComment");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, commentContent);
			pstmt.setInt(2, commentNo);
		
			result = pstmt.executeUpdate();	
			
		}finally {
	
			close(stmt);	
		}
		return result;
	}

	public Comment sameMember(Connection conn, int commentNo) throws SQLException {
		
		Comment comment = null;
		
		try {
		String sql = prop.getProperty("sameMember");
		
		stmt =conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		if(rs.next()) {
		int memberNo = rs.getInt("MEMBER_NO");
		
		comment = new Comment();
		
		comment.setMemberNo(memberNo);;
		}
		}finally{
			
			close(rs);
			close(stmt);
		}
		return comment;
	}

	public int deleteComment(Connection conn, int commentNo) throws SQLException {
		
		int result = 0; //결과 저장용 변수 선언
		
		try {
			
			String sql = prop.getProperty("deleteComment");
			
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, commentNo);
				
			result = pstmt.executeUpdate();
						
			
		}finally {
			//finally이유 view에서 모아서 처리하기 위함
			close(pstmt);	
		}
		return result;
	}
		
		
		



}
