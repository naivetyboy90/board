package reply.service;

import java.util.List;

import reply.dao.ReplyDao;
import reply.dao.ReplyDaoInf;
import reply.model.ReplyVO;

public class ReplyService implements ReplyServiceInf{

	
	private ReplyDaoInf dao;
	
	
	public ReplyService(){
		dao = ReplyDao.getInstance();
	}
	
	
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
	@Override
	public List<ReplyVO> getAllReply(int board_seq) {
		return dao.getAllReply(board_seq);
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
	@Override
	public int deleteReply(int comment_seq) {
		return dao.deleteReply(comment_seq);
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
	@Override
	public int insertReply(int board_seq, String content, String reg_id) {
		return dao.insertReply(board_seq, content, reg_id);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
