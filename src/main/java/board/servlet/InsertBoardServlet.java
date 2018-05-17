package board.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import member.servlet.LoginMember;
import attach.model.AttachVO;
import attach.service.AttachService;
import attach.service.AttachServiceInf;
import board.model.BoardVO;
import board.service.BoardService;
import board.service.BoardServiceInf;
import category.model.CategoryVO;
import category.service.CategoryService;
import category.service.CategoryServiceInf;

@WebServlet("/insertBoard")
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*3*5)
public class InsertBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardServiceInf boardService = new BoardService();
	CategoryServiceInf categoryService = new CategoryService();
	AttachServiceInf attachService = new AttachService();
	
	private final String UPLOAD_PATH = "D:\\A_TeachingMaterial\\7.JspSrpgin\\uploadStorage";
       
    public InsertBoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		String pageString = request.getParameter("page");
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		int pageSize = 10;
		
		int category_seq = Integer.parseInt(request.getParameter("category_seq"));
		String content = request.getParameter("smarteditor");
		String title = request.getParameter("boardTitle");
		String reg_id = request.getParameter("loginId");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("category_seq", category_seq);
		map.put("content", content);
		map.put("title", title);
		map.put("reg_id", reg_id);
		
		int check = boardService.insertBoard(map);
		
		int board_seq = (int) map.get("board_seq");
		
		
		Collection<Part> parts = request.getParts();
		
		for(Part part : parts){
			if(part.getName().equals("attachFile")){
				if(part.getSize() > 0){
					String filePath = UPLOAD_PATH + File.separator + UUID.randomUUID().toString();
					part.write(filePath);
					part.delete();
					System.out.println("filePath : " + filePath);
					
					String attach_route = filePath.substring(48);
					System.out.println("attach_route : " + attach_route);
					
					AttachVO attachVO = new AttachVO();
					attachVO.setAttach_route(attach_route);
					attachVO.setBoard_seq(board_seq);
					
					attachService.insertAttach(attachVO);
					
				}
			}
		}
		
		List<BoardVO> boardList = boardService.getBoardList(category_seq, page, pageSize);
		
		for (BoardVO boardVO : boardList) {
			boardVO.setTitle(boardVO.getTitle().replace(" ", "&nbsp"));
		}
		
		request.setAttribute("loginId", reg_id);
		
		List<CategoryVO> categoryList = categoryService.getCategoryList();
		
		String pageNav = boardService.getNav();
		
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("boardList", boardList);
		request.setAttribute("pageNav", pageNav);
		request.setAttribute("category_seq", category_seq);
		
		if(check > 0){
			RequestDispatcher rd = request.getRequestDispatcher("/boardView.jsp");
			rd.forward(request, response);
		}
	}

}

















