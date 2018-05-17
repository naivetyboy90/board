package board.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import board.model.BoardVO;

public class BoardDaoTest {
	BoardDaoInf dao = BoardDao.getInstance();

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
	//@Test
	public void getBoardList() {
		
		/***Given***/
		int category_seq = 1;
		int page = 1;
		int pageSize = 10;
		List<BoardVO> boardList = null;
		
		
		/***When***/
		boardList = dao.getBoardList(category_seq, page, pageSize);
		
		for (BoardVO boardVO : boardList) {
			System.out.println(boardVO.getTitle());
		}
		
		/***Then***/
		assertEquals(10, boardList.size());
		
	}
	
	
	/**
	 * 
	* Method : getBoardCnt
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "C.H.J"
	* 변경이력 :
	* @param category_seq
	* @return
	* Method 설명 : 해당 게시판의 게시글 개수 구하기
	 */
	//@Test
	public void getBoardCnt(){
		/***Given***/
		int cnt = 0;
		int category_seq = 1;

		/***When***/
		cnt = dao.getBoardCnt(category_seq);

		/***Then***/
		assertEquals(11, cnt);

	}
	
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
	//@Test
	public void getBoardDetail(){
		/***Given***/
		int board_seq = 1;
		BoardVO boardVO = null;
		
		/***When***/
		boardVO = dao.getBoardDetail(board_seq);

		/***Then***/
		assertNotNull(boardVO);
		assertEquals("test", boardVO.getReg_id());

	}
	
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
	//@Test
	public void deleteBoard(){
		/***Given***/
		int board_seq = 1;

		/***When***/
		int check = dao.deleteBoard(board_seq);

		/***Then***/
		assertEquals(1, check);

	}
	
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
	//@Test
	public void modifyBoard(){
		
		/***Given***/
		BoardVO boardVO = new BoardVO();
		boardVO.setBoard_seq(1);
		boardVO.setTitle("1번글 DaoTest중");
		boardVO.setContent("1번글 Dao 내용 수정 Test중");

		/***When***/
		int check = dao.modifyBoard(boardVO);

		/***Then***/
		assertEquals(1, check);

		
	}
	
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
	/*@Test
	public void insertBoard() {
		
		*//***Given***//*
		int category_seq = 1;
		String title = "Dao Test Title";
		String content = "Dao Test Content";
		String reg_id = "test";
		*//***When***//*
		int check = dao.insertBoard(category_seq, content, title, reg_id);

		*//***Then***//*
		assertEquals(1, check);

		
	}*/
	
	
	

}














