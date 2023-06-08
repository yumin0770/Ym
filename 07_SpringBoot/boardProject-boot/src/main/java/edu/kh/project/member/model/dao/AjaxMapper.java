package edu.kh.project.member.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface AjaxMapper {

	//이름으로 조회
	String selectNickname(String email);

	//닉네임으로 전화번호 조회
	String selectMemberTel(String nickname);
	
	//이메일 중복 검사
	/**
	 * @param email
	 * @return count
	 */
	int checkEmail(String email);
	
	 /**닉네임 중복 검사
	 * @param nickname
	 * @return count
	 */
	int checkNickname(String nickname);
	 
	  /**이메일로 회원정보 조회	
	    * @param email
		* @return
		*/
	 Member selectMember(String email);
	 
	  /**이메일이 일부라도 일치하는 모든회원 조회
		 * @param input
		 * @return
		 */
	 List<Member> selectMemberList(String input);
}
