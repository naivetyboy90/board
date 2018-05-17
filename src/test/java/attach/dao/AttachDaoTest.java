package attach.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import attach.model.AttachVO;

public class AttachDaoTest {
	AttachDaoInf dao = AttachDao.getInstance();
	
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
	//@Test
	public void insertAttach() {
		
		/***Given***/
		AttachVO attachVO = new AttachVO();
		int board_seq = 1;
		String attach_route = "0a6d535a-56dd-468b-8fb7-bd94275173a4"; 
		
		attachVO.setAttach_route(attach_route);
		attachVO.setBoard_seq(board_seq);

		/***When***/
		int check = dao.insertAttach(attachVO);
		
		/***Then***/
		assertEquals(1, check);

		
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
	@Test
	public void getAttachList() {
		
		/***Given***/
		int board_seq = 1;

		/***When***/
		List<AttachVO> list = dao.getAttachList(board_seq);

		/***Then***/
		assertEquals(3, list.size());
		
	}

}
