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
public class JoinProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public JoinProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String userHp = request.getParameter("userHp");
		String userEmail = request.getParameter("userEmail");
		int zipCode = Integer.parseInt(request.getParameter("zipCode"));
		
		String userAddr01 = request.getParameter("userAddr01");
		String userAddr02 = request.getParameter("userAddr02");
		String userAddr03 = request.getParameter("userAddr03");
		String address =  userAddr01 + userAddr02 + userAddr03;
		
		MemberDao memberDao = new MemberDao();
		MemberDto  memberDto = new MemberDto();
		memberDto.setUserId(userId);
		memberDto.setUserPw(userPw);
		memberDto.setUserName(userName);
		memberDto.setUserEmail(userEmail);
		memberDto.setUserHp(userHp);
		memberDto.setZipCode(zipCode);
		memberDto.setAddress(address);
		
		memberDto.toString();
		
		int result = memberDao.insertMember(memberDto);
		
		if(result>0) {
			ScriptWriter.alertAndNext(response, "회원가입 성공", "../index/");
		} else  {
			ScriptWriter.alertAndBack(response, "회원가입 실패 잠시후 다시 시도해 주세요.");
		}
	}
}
