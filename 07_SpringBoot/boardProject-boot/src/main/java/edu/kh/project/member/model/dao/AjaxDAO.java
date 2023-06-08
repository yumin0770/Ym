package edu.kh.project.member.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Repository // DB 연결 의미 + bean 등록 (IOC)
public class AjaxDAO {

   @Autowired // bean 중에서 타입이 같은 객체를 DI
   private AjaxMapper mapper;

   public String selectNickname(String email) {
   
	   //  return sqlSession.selectOne("ajaxMapper.selectNickname", email);
	   return mapper.selectNickname(email);
   }

   public String selectMemberTel(String nickname) {
	//  return sqlSession.selectOne("ajaxMapper.selectMemberTel", nickname);
	   return mapper.selectMemberTel(nickname);
 	
   }
   

   public int checkEmail(String email) {
	
	return mapper.checkEmail(email);
   }

   public int checkNickname(String nickname) {
	
	return mapper.checkNickname(nickname);

	}

   /**이메일로 회원정보 조회	
    * @param email
	* @return
	*/
   public Member selectMember(String email) {

	return mapper.selectMember(email);
}

	   /**이메일이 일부라도 일치하는 모든회원 조회
	 * @param input
	 * @return
	 */
	public List<Member> selectMemberList(String input) {
		
		return mapper.selectMemberList(input);
	}
}
	
