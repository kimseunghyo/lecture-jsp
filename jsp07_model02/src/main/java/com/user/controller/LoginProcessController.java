
package com.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.model.MemberDao;
import com.user.model.MemberDto;
import com.user.utils.ScriptWriter;

@WebServlet("/member/loginProcess")
public class LoginProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTf-8");
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
		memberDto.setUserId(userId);
		memberDto.setUserPw(userPw);
		MemberDto loggedMemberInfo = memberDao.getLoggedMemberInfo(memberDto);
		HttpSession session = request.getSession();
		
		if (loggedMemberInfo != null) {
			session.setAttribute("loggedId", loggedMemberInfo.getUserId());
			session.setAttribute("loggedName", loggedMemberInfo.getUserName());
			session.setAttribute("loggedMemberInfo", loggedMemberInfo);

			ScriptWriter.alertAndNext(response, "�α��� �Ǿ����ϴ�.", "../index/");
		} else {
			ScriptWriter.alertAndBack(response, "���̵� �н����� Ȯ���� �ּ���.");
		}
	}


}
