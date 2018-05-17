package board.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.servlet.LoginMember;
import board.service.BoardService;
import board.service.BoardServiceInf;
import category.model.CategoryVO;
import category.service.CategoryService;
import category.service.CategoryServiceInf;

@WebServlet("/insertBoardForm")
public class InsertBoardFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardServiceInf boardService = new BoardService();
	CategoryServiceInf categoryService = new CategoryService();
       
    public InsertBoardFormServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		int category_seq = Integer.parseInt(request.getParameter("category_seq"));
		request.setAttribute("category_seq", category_seq);
		
		List<CategoryVO> categoryList = categoryService.getCategoryList();
		request.setAttribute("categoryList", categoryList);
		
		String loginId = LoginMember.getMem_id();
		request.setAttribute("loginId", loginId);
		
		
		if(request.getParameter("group_seq") != null){
			int group_seq = Integer.parseInt(request.getParameter("group_seq"));
			request.setAttribute("group_seq", group_seq);
			int pboard_seq = Integer.parseInt(request.getParameter("pboard_seq"));
			request.setAttribute("pboard_seq", pboard_seq);
			RequestDispatcher rd = request.getRequestDispatcher("/replyBoard.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/insertBoard.jsp");
			rd.forward(request, response);
		}
		
		
		
	}

}

















