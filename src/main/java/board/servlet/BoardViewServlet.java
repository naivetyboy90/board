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
import category.model.CategoryVO;
import category.service.CategoryService;
import category.service.CategoryServiceInf;
import board.model.BoardVO;
import board.service.BoardService;
import board.service.BoardServiceInf;

/**
 * Servlet implementation class BoardViewServlet
 */
@WebServlet("/boardView")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardServiceInf boardService = new BoardService();
	CategoryServiceInf categoryService = new CategoryService();
       
    public BoardViewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pageString = request.getParameter("page");
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		int pageSize = 10;
		
		int category_seq = Integer.parseInt(request.getParameter("category_seq"));
		List<BoardVO> boardList = boardService.getBoardList(category_seq, page, pageSize);
		
		for (BoardVO boardVO : boardList) {
			boardVO.setTitle(boardVO.getTitle().replace(" ", "&nbsp"));
		}
		
		String loginId = LoginMember.getMem_id();
		request.setAttribute("loginId", loginId);
		
		List<CategoryVO> categoryList = categoryService.getCategoryList();
		
		String pageNav = boardService.getNav();
		
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("boardList", boardList);
		request.setAttribute("pageNav", pageNav);
		request.setAttribute("category_seq", category_seq);
		RequestDispatcher rd = request.getRequestDispatcher("/boardView.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
