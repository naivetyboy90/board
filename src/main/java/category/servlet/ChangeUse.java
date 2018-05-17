package category.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import category.model.CategoryVO;
import category.service.CategoryService;
import category.service.CategoryServiceInf;

@WebServlet("/changeUse")
public class ChangeUse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryServiceInf categoryService = new CategoryService();

	public ChangeUse() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int category_seq = Integer.parseInt(request.getParameter("category_seq"));
		String use_yn = request.getParameter("use_yn");
		
		CategoryVO vo = new CategoryVO();
		vo.setCategory_seq(category_seq);
		
		if(use_yn.equals("Y") || use_yn.equals("y")) {
			vo.setUse_yn("n");
		}else{
			vo.setUse_yn("y");
		}
		
		int check = categoryService.changeUse(vo);
		
		if(check > 0) {
			response.sendRedirect(request.getContextPath()+"/manageCategory");
		}else {
			response.sendRedirect(request.getContextPath()+"/getCategory");
		}
		
		
	}

}
