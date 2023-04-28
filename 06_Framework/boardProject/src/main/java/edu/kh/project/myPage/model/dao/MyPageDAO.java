package edu.kh.project.myPage.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Repository//DB랑 연결하는 역할하는 클래스 + Bean 등록(=spring이 객체 관리한=>IOC라한다)
public class MyPageDAO {
	
	//등록된 Bean 중 타입이 sqlSessionTemplate으로 일치하는 Bean을 주입(DI)디피덴트시 아이씨
	//-> root-context.xml에 <bean> 작성됨
	@Autowired //=의존성 주입된거임.
	private SqlSessionTemplate sqlSession;

	/**회원 정보 수정 DAO
	 * @param updateMember
	 * @return result
	 */
	public int updateInfo(Member updateMember) {
		
		
	//	return sqlSession.update("namespace.id", 전달할값);
		return sqlSession.update("myPageMapper.updateInfo",updateMember);
	
	}
	
	

}
