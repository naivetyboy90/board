package member.dao;

import static org.junit.Assert.*;
import member.dao.MemberDao;
import member.dao.MemberDaoInf;
import member.model.MemberVO;

import org.junit.Test;

public class MemberDaoTest {
	
	MemberDaoInf dao = MemberDao.getInstance();

	/**
	 * 
	* Method : tryLogin
	* 최초작성일 : 2018. 5. 11.
	* 작성자 : "C.H.J"
	* 변경이력 :
	* Method 설명 : 로그인 시도
	 */
	@Test
	public void tryLogin() {
		
		/***Given***/
		String mem_id = "test";
		String mem_pass = "1234";

		/***When***/
		MemberVO memVO = dao.tryLogin(mem_id, mem_pass);

		/***Then***/
		assertEquals("test", memVO.getMem_id());
		assertNotNull(memVO);

		
	}

}
