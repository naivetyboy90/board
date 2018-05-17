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

@WebServlet("/categoryForm")
public class CategoryForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryServiceInf categoryService = new CategoryService();
       
    public CategoryForm() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		List<CategoryVO> categoryList = categoryService.getCategoryList();
		request.setAttribute("categoryList", categoryList);
		String mem_id = LoginMember.getMem_id();
		request.setAttribute("mem_id", mem_id);
		
		RequestDispatcher rd = request.getRequestDispatcher("/categoryForm.jsp");
		rd.forward(request, response);
		
	}

}
