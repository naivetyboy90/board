package reply.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import reply.model.ReplyVO;

public class ReplyDao implements ReplyDaoInf {

	private static ReplyDaoInf dao = new ReplyDao();
	private SqlSessionFactory ssf;
	
	public static ReplyDaoInf getInstance() {
		return dao;
	}
	
	private ReplyDao(){
		String resource = "db/mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
			ssf = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		
		SqlSession sqlSession = ssf.openSession();
		List<ReplyVO> replyList = sqlSession.selectList("reply.getAllReply", board_seq);
		sqlSession.close();
		
		return replyList;
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
		
		SqlSession sqlSession = ssf.openSession();
		int check = sqlSession.update("reply.deleteReply", comment_seq);
		sqlSession.commit();
		sqlSession.close();
		
		return check;
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
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("board_seq", board_seq);
		map.put("content", content);
		map.put("reg_id", reg_id);
		
		SqlSession sqlSession = ssf.openSession();
		int check = sqlSession.insert("reply.insertReply", map);
		sqlSession.commit();
		sqlSession.close();
		
		return check;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
