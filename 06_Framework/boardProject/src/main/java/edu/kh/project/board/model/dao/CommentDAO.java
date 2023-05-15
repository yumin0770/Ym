package edu.kh.project.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.Comment;


@Repository // DB관련 + bean 등록 (IOC)
public class CommentDAO {

	@Autowired  //DI, root-context.xml에서 bean등록
	private SqlSessionTemplate sqlSession;

	public List<Comment> select(int boardNo) {

		return sqlSession.selectList("boardMapper.selectCommentList", boardNo);
	}

	public int insert(Comment comment) {
		return sqlSession.insert("commentMapper.insert",comment);
	}


	/**댓글삭제
	 * @param commentNo
	 * @return
	 */
	public int delete(int commentNo) {
	
		return sqlSession.update("commentMapper.delete",commentNo);
	}


	/**댓글 수정
	 * @param comment
	 * @return
	 */
	public int update(Comment comment) {
	
		return sqlSession.update("commentMapper.update",comment);
	}
	
	
}
