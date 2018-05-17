package board.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reply.model.ReplyVO;
import reply.service.ReplyService;
import reply.service.ReplyServiceInf;
import member.servlet.LoginMember;
import category.model.CategoryVO;
import category.service.CategoryService;
import category.service.CategoryServiceInf;
import attach.model.AttachVO;
import attach.service.AttachService;
import attach.service.AttachServiceInf;
import board.model.BoardVO;
import board.service.BoardService;
import board.service.BoardServiceInf;

@WebServlet("/getBoard")
public class GetBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BoardServiceInf boardService = new BoardService();
	CategoryServiceInf categoryService = new CategoryService();
	ReplyServiceInf replyService = new ReplyService();
	AttachServiceInf attachService = new AttachService();
       
    public GetBoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		int category_seq = Integer.parseInt(request.getParameter("category_seq"));
		request.setAttribute("category_seq", category_seq);
		
		BoardVO boardVO = boardService.getBoardDetail(board_seq);
		request.setAttribute("boardVO", boardVO);
		
		List<AttachVO> attachList = attachService.getAttachList(board_seq);
		request.setAttribute("attachList", attachList);
		
		List<CategoryVO> categoryList = categoryService.getCategoryList();
		request.setAttribute("categoryList", categoryList);
		
		String loginId = LoginMember.getMem_id();
		request.setAttribute("loginId", loginId);
		
		List<ReplyVO> replyList = replyService.getAllReply(boardVO.getBoard_seq());
		request.setAttribute("replyList", replyList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/boardDetail.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
