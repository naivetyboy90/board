package category.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import member.dao.MemberDao;
import member.dao.MemberDaoInf;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import category.model.CategoryVO;

public class CategoryDao implements CategoryDaoInf {
	
	private static CategoryDaoInf dao = new CategoryDao();
	private SqlSessionFactory ssf;
	
	public static CategoryDaoInf getInstance() {
		return dao;
	}
	
	private CategoryDao(){
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
	* Method : getCategoryList
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "C.H.J"
	* 변경이력 :
	* @return List<CategoryVO>
	* Method 설명 : 전체 게시판리스트 가져오기
	 */
	@Override
	public List<CategoryVO> getCategoryList() {
		
		SqlSession sqlSession = ssf.openSession();
		List<CategoryVO> categoryList = sqlSession.selectList("category.getCategoryList");
		sqlSession.close();
		
		return categoryList;
	}

	/**
	 * 
	* Method : getCategory
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "C.H.J"
	* 변경이력 :
	* @param category_seq
	* @return CategoryVO
	* Method 설명 : 게시판 1개의 정보 가져오기
	 */
	@Override
	public CategoryVO getCategory(int category_seq) {
		
		SqlSession sqlSession = ssf.openSession();
		CategoryVO categoryVO = sqlSession.selectOne("category.getCategory", category_seq);
		sqlSession.close();
		
		return categoryVO;
	}

	/**
	 * 
	* Method : changeUse
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "C.H.J"
	* 변경이력 :
	* @param vo
	* @return int (성공하면 0보다 큰 값 반환)
	* Method 설명 : 사용여부 변경
	 */
	@Override
	public int changeUse(CategoryVO vo) {
		
		int result = 0;
		
		SqlSession sqlSession = ssf.openSession();
		result = sqlSession.update("category.changeUse", vo);
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}

	
	/**
	 * 
	* Method : insertCategory
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "C.H.J"
	* 변경이력 :
	* @param vo
	* @return int (성공하면 0보다 큰 값 반환)
	* Method 설명 : 게시판 신규등록
	 */
	@Override
	public int insertCategory(CategoryVO vo) {
		
		int result = 0;
		
		SqlSession sqlSession = ssf.openSession();
		result = sqlSession.insert("category.insertCategory", vo);
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}

	

}
















