package member.service;

import member.model.MemberVO;

public interface MemberServiceInf {

	/**
	 * 
	* Method : tryLogin
	* 최초작성일 : 2018. 5. 11.
	* 작성자 : "C.H.J"
	* 변경이력 :
	* @param mem_id, mem_pass
	* @return MemberVO
	* Method 설명 : 로그인 시도
	 */
	public MemberVO tryLogin(String mem_id, String mem_pass);
	
}
