package edu.kh.project.board.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.project.board.model.dto.Board;

public interface BoardService {

	List<Map<String, Object>> selectBoardTypeList();
	
	
	/**게시글 목록 조회
	 * @param boardCode
	 * @param cp
	 * @return map
	 */
	Map<String, Object> selectBoardTypeList(int boardCode, int cp);


	/**게시글 상세 조회
	 * @param boardCode
	 * @param boardNo
	 * @return board
	 */
	Board selectBoard(Map<String, Object> map);


	/**좋아요 누르는 서비스
	 * @param map
	 * @return result
	 */
	int boardLikeCheck(Map<String, Object> map);


	/** 좋아요 처리 서비스
	    * @param paramMap
	    * @return count
	    */
	   int like(Map<String, Integer> paramMap);


	int updateReadCount(int boardNo);
	   


}
