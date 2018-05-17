package category.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import category.model.CategoryVO;

public class CategoryDaoTest {
	
	CategoryDaoInf dao = CategoryDao.getInstance();
	
	/**
	 * 
	* Method : getCategoryList
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "C.H.J"
	* 변경이력 :
	* @return List<CategoryVO>
	* Method 설명 : 전체 게시판리스트 가져오기
	 */
//	@Test
//	public void getCategoryListTest() {
//		
//		/***Given***/
//		List<CategoryVO> categoryList;
//
//		/***When***/
//		categoryList = dao.getCategoryList();
//		
//		/***Then***/
//		assertEquals(4, categoryList.size());
//		assertEquals("공지사항", categoryList.get(0).getCategory_name());
//
//	}
	
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
	@Test
	public void getCategory() {
		
		/***Given***/
		CategoryVO categoryVO;
		int category_seq = 1;

		/***When***/
		categoryVO = dao.getCategory(category_seq);
		
		/***Then***/
		assertNotNull(categoryVO);
		assertEquals("공지사항", categoryVO.getCategory_name());
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
	@Test
	public void changeUse() {
		
		/***Given***/
		CategoryVO categoryVO = new CategoryVO();
		int result = 0;
		categoryVO.setCategory_seq(1);
		categoryVO.setUse_yn("y");

		/***When***/
		result = dao.changeUse(categoryVO);
		
		/***Then***/
		assertEquals(1, result);
		
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
	@Test
	public void insertCategory() {
		
		/***Given***/
		CategoryVO categoryVO = new CategoryVO();
		int result = 0;
		categoryVO.setCategory_name("Q&A");
		categoryVO.setReg_id("test");
		
		/***When***/
		result = dao.insertCategory(categoryVO);
		
		/***Then***/
		assertEquals(1, result);
		
	}

}
