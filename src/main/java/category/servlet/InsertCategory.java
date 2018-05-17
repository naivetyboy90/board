package category.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.servlet.LoginMember;
import category.model.CategoryVO;
import category.service.CategoryService;
import category.service.CategoryServiceInf;

@WebServlet("/insertCategory")
public class InsertCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryServiceInf categoryService = new CategoryService();
	
    public InsertCategory() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String category_name = request.getParameter("category_name");
		String reg_id = request.getParameter("mem_id");
		
		CategoryVO vo = new CategoryVO();
		vo.setCategory_name(category_name);
		vo.setReg_id(reg_id);
		
		int check = categoryService.insertCategory(vo);
		if(check > 0) {
			List<CategoryVO> categoryList = categoryService.getCategoryList();
			
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("mem_id", LoginMember.getMem_id());
			
			RequestDispatcher rd = request.getRequestDispatcher("/manageCategory.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
