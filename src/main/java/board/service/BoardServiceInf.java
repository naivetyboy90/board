package board.service;

import java.util.List;
import java.util.Map;

import board.model.BoardVO;

public interface BoardServiceInf {

	/**
	 * 
	* Method : getBoardList
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "C.H.J"
	* 변경이력 :
	* @param category_seq
	* @param page
	* @param pageSize
	* @return
	* Method 설명 : 해당 게시판의 모든 게시글 가져오기
	 */
	public List<BoardVO> getBoardList(int category_seq, int page, int pageSize);
	
	/**
	 * 
	* Method : getNav
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "C.H.J"
	* 변경이력 :
	* @return String
	* Method 설명 : 생성된 네비게이션 가져오기
	 */
	public String getNav();
	
	/**
	 * 
	* Method : getBoardDetail
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "C.H.J"
	* 변경이력 :
	* @param board_seq
	* @return BoardVO
	* Method 설명 : 게시글의 상세정보 가져오기
	 */
	public BoardVO getBoardDetail(int board_seq);
	
	/**
	 * 
	* Method : deleteBoard
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "C.H.J"
	* 변경이력 :
	* @param board_seq
	* @return update된 행의 갯수 반환
	* Method 설명 : 게시물 삭제하기
	 */
	public int deleteBoard(int board_seq);
	
	/**
	 * 
	* Method : modifyBoard
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "C.H.J"
	* 변경이력 :
	* @param boardVO
	* @return update된 행의 갯수 반환
	* Method 설명 : 게시물 수정
	 */
	public int modifyBoard(BoardVO boardVO);
	
	/**
	 * 
	* Method : insertBoard
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "C.H.J"
	* 변경이력 :
	* @param category_seq
	* @param content
	* @param title
	* @param reg_id
	* @return 성공하면 1 반환
	* Method 설명 : 게시글 신규 등록
	 */
	public int insertBoard(Map<String, Object> map);
	
	/**
	 * 
	* Method : replyBoard
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "C.H.J"
	* 변경이력 :
	* @param map
	* @return 성공하면 1 반환
	* Method 설명 : 답글 등록
	 */
	public int replyBoard(Map<String, Object> map);
	
}














