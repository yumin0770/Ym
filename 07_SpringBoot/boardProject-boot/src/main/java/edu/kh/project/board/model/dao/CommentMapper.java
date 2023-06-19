package edu.kh.project.board.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.Comment;


@Mapper
public interface CommentMapper {



	/**댓글 조회
	 * @param boardNo
	 * @return
	 */
	public List<Comment> select(int boardNo);

	/**댓글 삽입
	 * @param comment
	 * @return
	 */
	public int insert(Comment comment);


	/**댓글삭제
	 * @param commentNo
	 * @return
	 */
	public int delete(int commentNo);


	/**댓글 수정
	 * @param comment
	 * @return
	 */
	public int update(Comment comment) ;
	
}
