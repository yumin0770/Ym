package edu.kh.project.member.model.service;

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
	 * @return
	 */
	int checkNickname(String nickname);

}
