package edu.kh.project.myPage.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Mapper//DB랑 연결하는 역할하는 클래스 + Bean 등록(=spring이 객체 관리한=>IOC라한다)
public interface MyPageMapper {
	
	/*
	 * //등록된 Bean 중 타입이 sqlSessionTemplate으로 일치하는 Bean을 주입(DI)디피덴트시 아이씨 //->
	 * root-context.xml에 <bean> 작성됨
	 * 
	 * @Autowired //=의존성 주입된거임. private SqlSessionTemplate sqlSession;
	 */

	/**회원 정보 수정 DAO
	 * @param updateMember
	 * @return result
	 */
	public int updateInfo(Member updateMember);

	/**회원 비밀번호 조회
	 * @param memberNo
	 * @return encPw
	 */
	public String selectEncPw(int memberNo);

	/**비밀번호 변경
	 * @param newPw
	 * @param memberNo
	 * @return result
	 */
	public int changePw(Member member);

	/** 회원탈퇴
	 * @param memberPw
	 * @param memberNo
	 * @return result
	 */
	public int secession(String memberPw, int memberNo);
	/** 프로필 이미지 수정
	 * @param loginMember
	 * @return result
	 */
	public int updateProfileImage(Member loginMember);
	

}
