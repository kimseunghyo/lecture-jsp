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

@WebServlet("/member/deleteProcess")
public class deleteProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public deleteProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("loggedId");
		String userPw = request.getParameter("userPw");
		
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
		memberDto.setUserId(userId);
		memberDto.setUserPw(userPw);
		
		int result = memberDao.deleteMember(memberDto);
		
		if(result>0) {
			ScriptWriter.alertAndNext(response, "회원탈퇴 성공", "../index/");
			session.invalidate();
		} else  {
			ScriptWriter.alertAndBack(response, "회원탈퇴 실패 잠시후 다시 시도해 주세요.");
		}
	}

}
