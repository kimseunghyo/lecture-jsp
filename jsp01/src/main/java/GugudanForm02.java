
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GugudanForm02
 */
@WebServlet("/GugudanForm02")
public class GugudanForm02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GugudanForm02() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action='/jsp01/GugudanResult' method='GET'>" + "<input type='radio' name='number' value='2'> 2��"
				+ "<input type='radio' name='number'  value='3'> 3��" + "<input type='radio' name='number'  value='4'> 4��"
				+ "<input type='radio' name='number'  value='5'> 5��" + "<input type='radio' name='number'  value='6'> 6��"
				+ "<input type='radio' name='number'  value='7'> 7��" + "<input type='radio' name='number'  value='8'> 8��"
				+ "<input type='radio' name='number'  value='9'> 9��" + "<button>������</button></form>");
		out.println("</body>");
		out.println("</html>");
	}

}
