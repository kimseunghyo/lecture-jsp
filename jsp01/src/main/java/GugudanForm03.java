

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GugudanForm03
 */
@WebServlet("/GugudanForm03")
public class GugudanForm03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GugudanForm03() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		out.println("<form action='/jsp01/GugudanResult' method='GET'>" + "<select name='number'>"
				+ "<option value = '2'>2��</option>"
				+ "<option value = '3'>3��</option>"
				+ "<option value = '4'>4��</option>"
				+ "<option value = '5'>5��</option>"
				+ "<option value = '6'>6��</option>"
				+ "<option value = '7'>7��</option>"
				+ "<option value = '8'>8��</option>"
				+ "<option value = '9'>9��</option>"
				+ "</select><button>������</button></form>");
		out.println("</body>");   
		out.println("</html>");
	}

}