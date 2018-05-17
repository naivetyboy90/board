package member.service;

import static org.junit.Assert.*;
import member.model.MemberVO;
import member.service.MemberService;
import member.service.MemberServiceInf;

import org.junit.Test;

public class MemberServiceTest {
	
	MemberServiceInf service = new MemberService();
	
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
		String mem_id = "b001";
		String mem_pass = "1004";

		/***When***/
		MemberVO memVO = service.tryLogin(mem_id, mem_pass);

		/***Then***/
		assertEquals("b001", memVO.getMem_id());
		assertNotNull(memVO);

	}

}
