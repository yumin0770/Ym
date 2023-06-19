package edu.kh.project.board.model.service;

import java.util.List;

import edu.kh.project.board.model.dto.Comment;

public interface CommentService {

	/**
	 * @param boardNo
	 * @return cList
	 */
	public List<Comment> select(int boardNo);

	/**
	 * @param comment
	 * @return
	 */
	int insert(Comment comment);

	/** 댓글 삭제
	 * @param commentNo
	 * @return result
	 */
	public int delete(int commentNo);

	/**댓글 수정
	 * @param comment
	 * @return result
	 */
	public int update(Comment comment);

}
