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
import reply.model.ReplyVO;
import reply.service.ReplyService;
import reply.service.ReplyServiceInf;
import board.model.BoardVO;
import board.service.BoardService;
import board.service.BoardServiceInf;
import category.model.CategoryVO;
import category.service.CategoryService;
import category.service.CategoryServiceInf;

@WebServlet("/insertReply")
public class InsertReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardServiceInf boardService = new BoardService();
	CategoryServiceInf categoryService = new CategoryService();
	ReplyServiceInf replyService = new ReplyService();
          
	
    public InsertReplyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		BoardVO boardVO = boardService.getBoardDetail(board_seq);
		String content = request.getParameter("replyContent");
		String reg_id = LoginMember.getMem_id();
		request.setAttribute("loginId", reg_id);
		request.setAttribute("boardVO", boardVO);
		
		int check = replyService.insertReply(board_seq, content, reg_id);
		
		List<ReplyVO> replyList = replyService.getAllReply(boardVO.getBoard_seq());
		request.setAttribute("replyList", replyList);
		List<CategoryVO> categoryList = categoryService.getCategoryList();
		request.setAttribute("categoryList", categoryList);
		
		if(check > 0){
			RequestDispatcher rd = request.getRequestDispatcher("/boardDetail.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
