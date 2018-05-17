package reply.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import reply.model.ReplyVO;

public class ReplyDaoTest {
	
	ReplyDaoInf dao = ReplyDao.getInstance();
	
	/**
	 * 
	* Method : getAllReply
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "C.H.J"
	* 변경이력 :
	* @param board_seq
	* @return
	* Method 설명 : 해당 게시글의 리플목록 가져오기
	 */
	@Test
	public void getAllReply() {
		
		/***Given***/
		int board_seq = 1;

		/***When***/
		List<ReplyVO> replyList = dao.getAllReply(board_seq);

		/***Then***/
		assertEquals(7, replyList.size());
		
	}
	
	/**
	 * 
	* Method : deleteReply
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "C.H.J"
	* 변경이력 :
	* @param comment_seq
	* @return update된 행의 갯수 반환
	* Method 설명 : 리플 삭제
	 */
	@Test
	public void deleteReply(){
		/***Given***/
		int comment_seq = 1;

		/***When***/
		int check = dao.deleteReply(comment_seq);
		
		/***Then***/
		assertEquals(1, check);
		
	}
	
	/**
	 * 
	* Method : insertReply
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "C.H.J"
	* 변경이력 :
	* @param board_seq
	* @param content
	* @param reg_id
	* @return 성공하면 1 반환
	* Method 설명 : 리플 등록
	 */
	@Test
	public void insertReply() {
		
		
		/***Given***/
		int board_seq = 1;
		String content = "리플 새로 추가 Dao 테스트";
		String reg_id = "test";

		/***When***/
		int check = dao.insertReply(board_seq, content, reg_id);
		
		/***Then***/
		assertEquals(1, check);
	
	}
	
	
	
	
	
	
	

}
