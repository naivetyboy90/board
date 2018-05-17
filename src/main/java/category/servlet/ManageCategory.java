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

@WebServlet("/manageCategory")
public class ManageCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryServiceInf categoryService = new CategoryService();
       
    
    public ManageCategory() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String loginId = LoginMember.getMem_id();
		request.setAttribute("loginId", loginId);
		
		List<CategoryVO> categoryList = categoryService.getCategoryList();
		
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("mem_id", LoginMember.getMem_id());
		
		RequestDispatcher rd = request.getRequestDispatcher("/manageCategory.jsp");
		rd.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
