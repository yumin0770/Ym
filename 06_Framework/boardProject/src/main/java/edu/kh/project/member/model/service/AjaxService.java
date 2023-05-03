package edu.kh.project.member.model.service;

import java.util.List;

import edu.kh.project.member.model.dto.Member;

public interface AjaxService {

	/**
	 * @param email
	 * @return
	 */
	String selectNickname(String email);

	/**
	 * @param nickname
	 * @return
	 */
	String selectMemberTel(String nickname);

	/**이메일 중복 확인
	 * @param email
	 * @return
	 */
	int checkEmail(String email);

	/**닉네임 중복 확인
	 * @param nickname
	 * @return count
	 */
	int checkNickname(String nickname);

	/**이메일로 회원 정보 조회
	 * @param email
	 * @return member
	 */
	Member selectMember(String email);

	/**이메일이 일부라도 일치하는 모든회원 조회
	 * @param input
	 * @return memberList
	 */
	List<Member> selectMemberList(String input);



}
