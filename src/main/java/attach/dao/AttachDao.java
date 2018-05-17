package attach.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.model.BoardVO;
import attach.model.AttachVO;

public class AttachDao implements AttachDaoInf{

	private static AttachDaoInf dao = new AttachDao();
	private SqlSessionFactory ssf;
	
	public static AttachDaoInf getInstance() {
		return dao;
	}
	
	private AttachDao(){
		
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
		
		SqlSession sqlSession = ssf.openSession();
		int check = sqlSession.insert("attach.insertAttach", attachVO);
		sqlSession.commit();
		sqlSession.close();
		
		return check;
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
		
		SqlSession sqlSession = ssf.openSession();
		List<AttachVO> attachList = sqlSession.selectList("attach.getAttachList", board_seq);
		sqlSession.commit();
		sqlSession.close();
		
		return attachList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
