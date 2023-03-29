package edu.kh.jdbc.board.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.board.model.dto.Board;

public class BoardDAO {
	
	
	//JDBC 객체 참조 변수
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//XML에 작성되 SQL을 읽어와 저잘항 객체를 참조하는 변수
	private Properties prop;
	
	public BoardDAO() {
		
		try {		
			prop =  new Properties();
			prop.loadFromXML(new FileInputStream("board-sql.xml"));
	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/** 1.게시판 목록 조회
	 * @param conn
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectAllBoard(Connection conn) throws Exception {
		
		List<Board> boardList = new ArrayList<>();
		
		try {
			
			
			//SQL 작성
			String sql =  prop.getProperty("selectAllBoard");
			
			//SQL 수행 후 결과 반환 받기
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			//1행씩 접근하여 컬럼 값 얻어와 옮겨담기
			while(rs.next()) {
				
				int boardNo = rs.getInt("BOARD_NO");
				String boardTiltle = rs.getString("BOARD_TITLE");
				String memberName = rs.getString("MEMBER_NM");
				int readCount = rs.getInt("READ_COUNT");
				String createDate = rs.getString("CREATE_DT");
				int commentCount = rs.getInt("COMMENT_COUNT");
				
				
				Board board = new Board (); //DTO 생성자 만들어줌, 값 저장하기 위해
				
				board.setBoardNo(boardNo);
				board.setBoardTitle(boardTiltle);
				board.setMemberName(memberName);
				board.setReadCount(readCount);
				board.setCreateDate(createDate);
				board.setCommentCount(commentCount);
				
				
				boardList.add(board);
			}
		}finally {	
			close(rs);
			close(stmt);
		}	
		return boardList;
	}

	/**2.게시글 상제 조회 SQL 수행
	 * @param conn
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public Board selectBoard(Connection conn, int input) throws Exception{

		Board board = null;
		
		try {
			
			String sql = prop.getProperty("selectBoard");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,input);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				int boardNo = rs.getInt("BOARD_NO");
				String boardTiltle = rs.getString("BOARD_TITLE");
				String memberName = rs.getString("MEMBER_NM");
				int readCount = rs.getInt("READ_COUNT");
				String createDate = rs.getString("CREATE_DT");
				
				String boardcontent = rs.getString("BOARD_CONTENT");
				int memberNo = rs.getInt("MEMBER_NO");
				
				board = new Board();
				
				board.setBoardNo(boardNo);
				board.setBoardTitle(boardTiltle);
				board.setMemberName(memberName);
				board.setReadCount(readCount);
				board.setCreateDate(createDate);
				board.setBoardContent(boardcontent);
				board.setMemberNo(memberNo);
			}
		}finally{		
			close(rs);
			close(pstmt);
		}
		return board;
	}

	/**조회수 증가 SQL 수행
	 * @param conn
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public int updateReadCount(Connection conn, int input) throws Exception {
		
		int result = 0;
		
		try {
		String sql = prop.getProperty("updateReadCount");
		
		pstmt= conn.prepareStatement(sql);
		pstmt.setInt(1, input);
		
		result = pstmt.executeUpdate();
		
		}finally {
			close(pstmt);
		}
		return result;
	}

	/**게시글 수정
	 * @param conn
	 * @param boardTitle
	 * @param boardContent
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int updateBoard(Connection conn, String boardTitle, String boardContent, int boardNo) 
	 						throws Exception{
		
		int result = 0;
		
		try {
		String sql = prop.getProperty("updateBoard");
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, boardTitle);
		pstmt.setString(2, boardContent);
		pstmt.setInt(3, boardNo);
		
		result = pstmt.executeUpdate();
		
		}finally {
			
			close(pstmt);
		}
		
		return result;
	}

	/**게시글 삭제
	 * @param conn
	 * @param boardNo
	 * @return
	 * @throws Exception
	 */
	public int deleteBoard(Connection conn, int boardNo) throws Exception {
		
		int result = 0; //결과 저장용 변수 선언
				
		try {
			
			String sql = prop.getProperty("deleteBoard");
			
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
				
			result = pstmt.executeUpdate();
						//DDL 수행도 가능 (CREATE,ALTER,DROP)
						//결과로 -1 반환
			
		}finally {
			//finally이유 view에서 모아서 처리하기 위함
			close(pstmt);	
		}
		return result;
	}

	/**다음 게시글 번호 생성 SQL 수행
	 * @param conn
	 * @return boardNo
	 * @throws Exception
	 */
	public int nextBoardNumber(Connection conn) throws Exception {
		
		int boardNo = 0;
		
		try {
			String sql = prop.getProperty("nextBoardNo");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				boardNo = rs.getInt(1);
			}	
			
		}finally {
			close(rs);
			close(stmt);	
		}
		return boardNo;
	}

	/** 게시글 삽입
	 * @param conn
	 * @param boardTitle
	 * @param boardContent
	 * @param memberNo
	 * @param boardNo
	 * @return
	 * @throws Exception
	 */	
	public int insetBoard(Connection conn, String boardTitle, String boardContent, int memberNo, int boardNo) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("insetBoard");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,boardNo);
			pstmt.setString(2,boardTitle);
			pstmt.setString(3,boardContent);
			pstmt.setInt(4,memberNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			
			close(pstmt);
		}		
		return result;
	}
	
}
