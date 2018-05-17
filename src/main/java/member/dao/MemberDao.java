package member.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import member.model.MemberVO;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDao implements MemberDaoInf{

	private static MemberDaoInf dao = new MemberDao();
	private SqlSessionFactory ssf;
	
	public static MemberDaoInf getInstance() {
		return dao;
	}
	
	private MemberDao(){
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
	* Method : tryLogin
	* 최초작성일 : 2018. 5. 11.
	* 작성자 : "C.H.J"
	* 변경이력 :
	* @param mem_id, mem_pass
	* @return MemberVO
	* Method 설명 : 로그인 시도
	 */
	@Override
	public MemberVO tryLogin(String mem_id, String mem_pass) {
		
		Map<String, String> logMap = new HashMap<String, String>();
		logMap.put("mem_id", mem_id);
		logMap.put("mem_pass", mem_pass);
		
		SqlSession sqlSession = ssf.openSession();
		MemberVO memVO = sqlSession.selectOne("member.tryLogin", logMap);
		sqlSession.close();
		
		return memVO;
	}

}
