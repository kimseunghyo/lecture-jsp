
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckBoxSender
 */
@WebServlet("/CheckBoxSender")
public class CheckBoxSender extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckBoxSender() {
		super();

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
		out.println("<h1>check box ������ ������ </h1>");
		out.println("<form method = 'GET' action = '/jsp02/CheckboxReceiver'>" + "<p>���� �о߸� �����ϼ���.</p>"
				+ "<input type = 'checkbox' name = 'interest' value = '�ڹ�'><span>�ڹ�</span>"
				+ "<input type = 'checkbox' name = 'interest' value = '���̽�'><span>���̽�</span>"
				+ "<input type = 'checkbox' name = 'interest' value = '�ڹٽ�ũ��Ʈ'><span>�ڹٽ�ũ��Ʈ</span>"
				+ "<input type = 'checkbox' name = 'interest' value = '����'><span>C#</span>"
				+ "<input type = 'checkbox' name = 'interest' value = 'Go'><span>Go</span>" + "<button>send</button>"
				+ "</form>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}