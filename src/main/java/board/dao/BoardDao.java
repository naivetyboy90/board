package board.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.model.BoardVO;

public class BoardDao implements BoardDaoInf {
	
	private static BoardDaoInf dao = new BoardDao();
	private SqlSessionFactory ssf;
	
	public static BoardDaoInf getInstance() {
		return dao;
	}
	
	private BoardDao(){
		String resource = "db/mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
			ssf =new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("category_seq", category_seq);
		map.put("page", page);
		map.put("pageSize", pageSize);
		
		
		SqlSession sqlSession = ssf.openSession();
		List<BoardVO> boardList = sqlSession.selectList("board.getBoardList", map);
		sqlSession.close();
		
		return boardList;
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
	@Override
	public int getBoardCnt(int category_seq) {
		
		SqlSession sqlSession = ssf.openSession();
		int cnt = sqlSession.selectOne("board.getBoardCnt", category_seq);
		sqlSession.close();
		
		return cnt;
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
		
		SqlSession sqlSession = ssf.openSession();
		BoardVO boardVO = sqlSession.selectOne("board.getBoardDetail", board_seq);
		sqlSession.close();
		
		return boardVO;
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
	@Override
	public int deleteBoard(int board_seq) {
		SqlSession sqlSession = ssf.openSession();
		int chk = sqlSession.update("board.deleteBoard", board_seq);
		sqlSession.commit();
		sqlSession.close();
		
		return chk;
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
		SqlSession sqlSession = ssf.openSession();
		int chk = sqlSession.update("board.modifyBoard", boardVO);
		sqlSession.commit();
		sqlSession.close();
		
		return chk;
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
		
		SqlSession sqlSession = ssf.openSession();
		int chk = sqlSession.insert("board.insertBoard", map);
		sqlSession.commit();
		sqlSession.close();
		
		return chk;
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
		
		SqlSession sqlSession = ssf.openSession();
		int chk = sqlSession.insert("board.replyBoard", map);
		sqlSession.commit();
		sqlSession.close();
		
		return chk;
	}

}















