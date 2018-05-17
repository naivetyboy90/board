package member.service;

import member.dao.MemberDao;
import member.dao.MemberDaoInf;
import member.model.MemberVO;

public class MemberService implements MemberServiceInf {
	
	private MemberDaoInf dao;
	
	public MemberService() {
		dao = MemberDao.getInstance();
	}
	

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
	@Override
	public MemberVO tryLogin(String mem_id, String mem_pass) {
		return dao.tryLogin(mem_id, mem_pass);
	}

}
