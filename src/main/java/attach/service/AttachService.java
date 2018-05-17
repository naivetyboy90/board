package attach.service;

import java.util.List;

import attach.dao.AttachDao;
import attach.dao.AttachDaoInf;
import attach.model.AttachVO;

public class AttachService implements AttachServiceInf {

	private AttachDaoInf dao;
	
	public AttachService(){
		dao = AttachDao.getInstance();
	}
	
	/**
	 * 
	* Method : insertAttach
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "C.H.J"
	* 변경이력 :
	* @param attachVO
	* @return 성공하면 1
	* Method 설명 : 첨부화일 등록
	 */
	@Override
	public int insertAttach(AttachVO attachVO) {
		return dao.insertAttach(attachVO);
	}

	
	/**
	 * 
	* Method : getAttachList
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "C.H.J"
	* 변경이력 :
	* @param board_seq
	* @return
	* Method 설명 : 해당 게시글의 첨부화일 목록 가져오기
	 */
	@Override
	public List<AttachVO> getAttachList(int board_seq) {
		return dao.getAttachList(board_seq);
	}

}
