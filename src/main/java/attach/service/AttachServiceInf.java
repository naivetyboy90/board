package attach.service;

import java.util.List;

import attach.model.AttachVO;

public interface AttachServiceInf {

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
	public int insertAttach(AttachVO attachVO);
	
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
	public List<AttachVO> getAttachList(int board_seq);
	
}
