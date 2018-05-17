package board.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.service.BoardServiceInf;
import category.model.CategoryVO;
import category.service.CategoryService;
import category.service.CategoryServiceInf;

@WebServlet("/deleteBoard")
public class DeleteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardServiceInf boardService = new BoardService();
	CategoryServiceInf categoryService = new CategoryService();
       
    public DeleteBoardServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int category_seq = Integer.parseInt(request.getParameter("category_seq"));
		request.setAttribute("category_seq", category_seq);
		
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		int check = boardService.deleteBoard(board_seq);
		
		List<CategoryVO> categoryList = categoryService.getCategoryList();
		request.setAttribute("categoryList", categoryList);
		
		
		if(check > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/boardView");
			rd.forward(request, response);
		}
	}

}
