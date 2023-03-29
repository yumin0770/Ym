package edu.kh.jdbc.board.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.close;
import static edu.kh.jdbc.common.JDBCTemplate.commit;
import static edu.kh.jdbc.common.JDBCTemplate.getConnection;
import static edu.kh.jdbc.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.jdbc.board.model.dao.BoardDAO;
import edu.kh.jdbc.board.model.dao.CommentDAO;
import edu.kh.jdbc.board.model.dto.Comment;

public class CommentService {
	
	private CommentDAO commentDao = new CommentDAO();

	/** 댓글 삽입
	 * @param commentContent
	 * @param boardNo
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int insertComment(String commentContent, int boardNo, int memberNo) throws Exception {
		
		Connection conn = getConnection();
		
	
		int commentNo = commentDao.nextCommentNumber(conn);
		
		int result =  commentDao.insetBoard(conn,commentContent,boardNo,memberNo,commentNo);
		
		if(result > 0) {
			commit(conn);
			result = boardNo;
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		
		return result;
	}

	public int updateComment(int commentNo, String commentContent) throws SQLException {
		
		Connection conn = getConnection();
		
		int result =  commentDao.updateComment(conn,commentNo,commentContent);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		
		return result;
	}

	public Comment sameMember(int commentNo) throws SQLException {

		Connection conn = getConnection();
		
		Comment comment = commentDao.sameMember(conn,commentNo);
		
		close(conn);
		
		return comment;
	}

	public int deleteComment(int commentNo) throws SQLException {
	
		
		Connection conn = getConnection();
		
		int result = commentDao.deleteComment(conn,commentNo);
		
		if(result > 0 ) commit(conn);
		else 			rollback(conn);
		
		
		close(conn);
		
		return result;
	}
		
		
	




	
	

}
