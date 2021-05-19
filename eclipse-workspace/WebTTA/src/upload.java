

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;




/**
 * Servlet implementation class upload
 */
@WebServlet("/upload")
@MultipartConfig(maxFileSize=1024*1024*2, location="c:\\upload")

public class upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8;");
        response.setCharacterEncoding("UTF-8");
        Part part = request.getPart("theFile");
        String fileName = getFilename(part);
       
        if(fileName != null && !fileName.isEmpty()){
            part.write(fileName);
        }
        PrintWriter out = response.getWriter();

        out.println("업로드 되었습니다.");
	}

	   private String getFilename(Part part){
	        String fileName = null;        
	        String contentDispositionHeader = part.getHeader("content-disposition");
	        String [] elements = contentDispositionHeader.split(";");
	        for(String element: elements){
	            fileName = element.substring(element.indexOf('=')+1);
	            fileName = fileName.trim().replace("\""," "); // " <- 쌍따옴표 지움
	        }        
	        return fileName;        
	    }


}
