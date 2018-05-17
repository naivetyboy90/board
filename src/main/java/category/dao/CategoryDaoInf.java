package category.dao;

import java.util.List;

import category.model.CategoryVO;

public interface CategoryDaoInf {

	/**
	 * 
	* Method : getCategoryList
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "C.H.J"
	* 변경이력 :
	* @return List<CategoryVO>
	* Method 설명 : 전체 게시판리스트 가져오기
	 */
	public List<CategoryVO> getCategoryList();
	
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
	public CategoryVO getCategory(int category_seq);
	
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
	public int changeUse(CategoryVO vo);
	
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
	public int insertCategory(CategoryVO vo);
	
}
