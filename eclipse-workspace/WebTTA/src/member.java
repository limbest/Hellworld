

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class member
 */
@WebServlet("/member")
public class member extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public member() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("sf_name");
		String password = request.getParameter("sf_pass");
		String file = request.getParameter("sf_file");
		System.out.println("TEST");
		// DB연결
		// SQL실행
		// 결과 
		//memberDAO mymember = new memberDAO();
		//mymember.DBInsert(name, password, file);
		
		PrintWriter out = response.getWriter();
		out.println("Member Web Site");
		out.println("");


		//response.sendRedirect("result.html");
	}

}
