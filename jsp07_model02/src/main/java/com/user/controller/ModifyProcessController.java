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

/**
 * Servlet implementation class ModifyProcessController
 */
@WebServlet("/member/modifyProcess")
public class ModifyProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public ModifyProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("loggedId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String userHp = request.getParameter("userHp");
		String userEmail = request.getParameter("userEmail");
		int zipCode = Integer.parseInt(request.getParameter("zipCode"));
		
		String userAddr01 = request.getParameter("userAddr01");
		String userAddr02 = request.getParameter("userAddr02");
		String userAddr03 = request.getParameter("userAddr03");
		String address =  userAddr01 + userAddr02 + userAddr03;
		
		System.out.println(userId + userPw + userName + userHp + userEmail + zipCode + address);
		
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
		memberDto.setUserId(userId);
		memberDto.setUserPw(userPw);
		memberDto.setUserName(userName);
		memberDto.setUserEmail(userEmail);
		memberDto.setUserHp(userHp);
		memberDto.setZipCode(zipCode);
		memberDto.setAddress(address);
		
		memberDto.toString();
		
		int result = memberDao.updateMember(memberDto);
		
		if(result>0) {
			ScriptWriter.alertAndNext(response, "회원정보수정 성공", "../index/");
		} else  {
			ScriptWriter.alertAndBack(response, "회원정보수정 실패 잠시후 다시 시도해 주세요.");
		}
	}

}
