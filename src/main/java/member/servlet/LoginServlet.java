package member.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import category.model.CategoryVO;
import category.service.CategoryService;
import category.service.CategoryServiceInf;
import member.model.MemberVO;
import member.service.MemberService;
import member.service.MemberServiceInf;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberServiceInf memberService = new MemberService();
	CategoryServiceInf categoryService = new CategoryService();
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");
		
		MemberVO memVO = memberService.tryLogin(mem_id, mem_pass);
		
		if(memVO != null) {
			
			LoginMember.setMem_id(mem_id);
			
			List<CategoryVO> categoryList = categoryService.getCategoryList();
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("memVO", memVO);
			
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
			
		} else {
			response.sendRedirect("login.jsp");
			
		}
		
		
	}

}
