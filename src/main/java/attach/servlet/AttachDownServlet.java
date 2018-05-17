package attach.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/attachDown")
public class AttachDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_PATH = "D:\\A_TeachingMaterial\\7.JspSrpgin\\uploadStorage";
       
    public AttachDownServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fileName = request.getParameter("fileName");
		File f = new File(UPLOAD_PATH + File.separator + fileName);
		
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		response.setContentType("application/octet-stream");
		response.setContentLength((int)f.length());
		
		FileInputStream fis = new FileInputStream(f);
		ServletOutputStream sos = response.getOutputStream();
		
		byte[] buffer = new byte[512];
		int len = -1;
		while( (len = fis.read(buffer)) != -1 ) {
			sos.write(buffer, 0, len);
		}
		fis.close();
		sos.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
