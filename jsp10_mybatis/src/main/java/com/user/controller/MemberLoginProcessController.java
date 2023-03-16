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
public class MemberLoginProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLoginProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDto memberDto = new MemberDto();
		memberDto.setUserId(request.getParameter("userId"));
		memberDto.setUserPw(request.getParameter("userPw"));
		MemberDao memberDao =  new MemberDao();
		MemberDto loggedMember = memberDao.getLoggedMember(memberDto);
		
		HttpSession session = request.getSession();
		
		if (loggedMember != null) {
			session.setAttribute("loggedName", loggedMember.getUserId());
			session.setAttribute("loggedName", loggedMember.getUserName());
			session.setAttribute("loggedMember", loggedMember);
			ScriptWriter.alertAndNext(response, "로그인 되었습니다.", "../index/");
		} else {
			ScriptWriter.alertAndBack(response, "아이디 패스워드 확인해 주세요.");
		}
	}

}
