package category.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import category.model.CategoryVO;
import category.service.CategoryService;
import category.service.CategoryServiceInf;

@WebServlet("/getCategory")
public class GetCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryServiceInf categoryService = new CategoryService();
       
    public GetCategory() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int category_seq = Integer.parseInt(request.getParameter("category_seq"));
		
		CategoryVO categoryVO = categoryService.getCategory(category_seq);
		request.setAttribute("categoryList", categoryService.getCategoryList());
		request.setAttribute("categoryVO", categoryVO);
		
		RequestDispatcher rd = request.getRequestDispatcher("/category.jsp");
		rd.forward(request, response);
		
	}

}




