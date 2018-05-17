package category.service;

import java.util.List;

import category.dao.CategoryDao;
import category.dao.CategoryDaoInf;
import category.model.CategoryVO;

public class CategoryService implements CategoryServiceInf{

	private CategoryDaoInf dao;
	
	public CategoryService(){
		dao = CategoryDao.getInstance();
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
		return dao.getCategoryList();
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
		return dao.getCategory(category_seq);
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
		return dao.changeUse(vo);
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
		return dao.insertCategory(vo);
	}
	

}
