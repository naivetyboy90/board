package board.service;

import java.util.List;
import java.util.Map;

import board.dao.BoardDao;
import board.dao.BoardDaoInf;
import board.model.BoardVO;

public class BoardService implements BoardServiceInf{

	private BoardDaoInf dao;
	private static String pageNav = "";
	
	public BoardService(){
		dao = BoardDao.getInstance();
	}
	
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
	@Override
	public List<BoardVO> getBoardList(int category_seq, int page, int pageSize) {
		//System.out.println("page : " +page);
		
		List<BoardVO> boardList = dao.getBoardList(category_seq, page, pageSize);
		int boardCnt = dao.getBoardCnt(category_seq);
		pageNav = makePageNav(page, boardCnt, category_seq);
		
		return boardList;
	}
	
	
	/**
	 * 
	* Method : makePageNav
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "C.H.J"
	* 변경이력 :
	* @param page
	* @param boardCnt
	* @return
	* Method 설명 : pageNavigation 생성
	 */
	private String makePageNav(int page, int boardCnt, int category_seq) {
		
		int pageTotalCnt = (int) (Math.ceil( (double)boardCnt / 10));
		
		StringBuffer pageNav = new StringBuffer();
		pageNav.append("");
		pageNav.append("<nav>");
		pageNav.append("  <ul class='pagination'>");
		
		if(page==1){
			pageNav.append("	<li class='page-item disabled'>");
			pageNav.append("  		<a href= '#'>");
			pageNav.append("   			<span aria-hidden='true'>&laquo;</span>");
			pageNav.append(" 		</a>");
			pageNav.append("	</li>");
			pageNav.append("	<li class='page-item disabled'>");
			pageNav.append("  		<a href= '#'>");
			pageNav.append("   			<span aria-hidden='true'>&lsaquo;</span>");
			pageNav.append(" 		</a>");
			pageNav.append("	</li>");
		}else{
			pageNav.append("	<li>");
			pageNav.append("		<a href='boardView?category_seq=" + category_seq + "&page=1&pageSize=10' aria-label='Previous'>");
			pageNav.append("   			<span aria-hidden='true'>&laquo;</span>");
			pageNav.append(" 		</a>");
			pageNav.append("	</li>");
			pageNav.append("	<li>");
			pageNav.append("		<a href='boardView?category_seq=" + category_seq + "&page=" + (page-1) + "&pageSize=10' aria-label='Previous'>");
			pageNav.append("   			<span aria-hidden='true'>&lsaquo;</span>");
			pageNav.append(" 		</a>");
			pageNav.append("	</li>");
		}
		
		
		for (int i = 1; i <= pageTotalCnt; i++) {
			if(i == page)
				pageNav.append("	<li class='active'><a href='boardView?category_seq=" + category_seq + "&page=" + i + "&pageSize=10'>"+ i +"</a></li>");
			else
				pageNav.append("	<li><a href='boardView?category_seq=" + category_seq + "&page=" + i + "&pageSize=10'>"+ i +"</a></li>");
				
		}
		
		if(page==pageTotalCnt){
			pageNav.append("	<li class='page-item disabled'>");
			pageNav.append("  		<a href= '#'>");
			pageNav.append("    		<span aria-hidden='true'>&rsaquo;</span>");
			pageNav.append("  		</a>");
			pageNav.append("	</li>");
			pageNav.append("	<li class='page-item disabled'>");
			pageNav.append("  		<a href= '#'>");
			pageNav.append("    		<span aria-hidden='true'>&raquo;</span>");
			pageNav.append("  		</a>");
			pageNav.append("	</li>");
		}else{
			pageNav.append("	<li>");
			pageNav.append("  		<a href= 'boardView?category_seq=" + category_seq + "&page=" + (page+1) + "&pageSize=10' aria-label='Next'>");
			pageNav.append("    		<span aria-hidden='true'>&rsaquo;</span>");
			pageNav.append("  		</a>");
			pageNav.append("	</li>");
			pageNav.append("	<li>");
			pageNav.append("  		<a href= 'boardView?category_seq=" + category_seq + "&page=" + pageTotalCnt + "&pageSize=10' aria-label='Next'>");
			pageNav.append("    		<span aria-hidden='true'>&raquo;</span>");
			pageNav.append("  		</a>");
			pageNav.append("	</li>");
		}
		
		
		pageNav.append("  </ul>");
		pageNav.append("</nav>");
	
		return pageNav.toString();
	}

	/**
	 * 
	* Method : getNav
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "C.H.J"
	* 변경이력 :
	* @return String
	* Method 설명 : 생성된 네비게이션 가져오기
	 */
	@Override
	public String getNav(){
		return pageNav;
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
	@Override
	public BoardVO getBoardDetail(int board_seq) {
		return dao.getBoardDetail(board_seq);
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
	public int deleteBoard(int board_seq){
		return dao.deleteBoard(board_seq);
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
	@Override
	public int modifyBoard(BoardVO boardVO) {
		return dao.modifyBoard(boardVO);
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
	@Override
	public int insertBoard(Map<String, Object> map) {
		return dao.insertBoard(map);
	}

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
	@Override
	public int replyBoard(Map<String, Object> map) {
		return dao.replyBoard(map);
	};

	

}
