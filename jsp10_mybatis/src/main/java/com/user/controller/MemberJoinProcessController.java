package com.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.model.MemberDao;
import com.user.model.MemberDto;
import com.user.utils.ScriptWriter;

@WebServlet("/member/joinProcess")
public class MemberJoinProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberJoinProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberDto memberDto = new MemberDto();
		memberDto.setUserId(request.getParameter("userId"));
		memberDto.setUserPw(request.getParameter("userPw"));
		memberDto.setUserName(request.getParameter("userName"));
		MemberDao memberDao = new MemberDao();
		int result = memberDao.insertMember(memberDto);
		
		if (result > 0) {
			ScriptWriter.alertAndNext(response, "회원가입 되었습니다.", "../index/");
		} else {
			ScriptWriter.alertAndBack(response, "회원가입 실패 잠시후 다시 시도해 주세요.");
		}
	}

}
