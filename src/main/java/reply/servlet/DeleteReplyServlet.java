package reply.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.servlet.LoginMember;
import board.model.BoardVO;
import board.service.BoardService;
import board.service.BoardServiceInf;
import category.model.CategoryVO;
import category.service.CategoryService;
import category.service.CategoryServiceInf;
import reply.model.ReplyVO;
import reply.service.ReplyService;
import reply.service.ReplyServiceInf;

@WebServlet("/deleteReply")
public class DeleteReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardServiceInf boardService = new BoardService();
	CategoryServiceInf categoryService = new CategoryService();
	ReplyServiceInf replyService = new ReplyService();
       
    public DeleteReplyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
//		int category_seq = Integer.parseInt(request.getParameter("category_seq"));
//		request.setAttribute("category_seq", category_seq);

		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		BoardVO boardVO = boardService.getBoardDetail(board_seq);

		int comment_seq = Integer.parseInt(request.getParameter("comment_seq"));
		int check = replyService.deleteReply(comment_seq);
		
		
		List<ReplyVO> replyList = replyService.getAllReply(boardVO.getBoard_seq());
		request.setAttribute("replyList", replyList);

		List<CategoryVO> categoryList = categoryService.getCategoryList();
		request.setAttribute("categoryList", categoryList);
		
		String loginId = LoginMember.getMem_id();
		request.setAttribute("loginId", loginId);
		request.setAttribute("boardVO", boardVO);
		
		if(check > 0){
			RequestDispatcher rd = request.getRequestDispatcher("/boardDetail.jsp");
			rd.forward(request, response);
		}
		
	}

}
