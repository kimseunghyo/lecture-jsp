package com.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.model.BoardDao;
import com.user.model.BoardDto;
import com.user.utils.ScriptWriter;

@WebServlet("/board/writeProcess")
public class boardWriteProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public boardWriteProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		BoardDto boardDto = new BoardDto();
		boardDto.setUserName(userName);
		boardDto.setTitle(title);
		boardDto.setContents(contents);
		BoardDao boardDao = new BoardDao();
		int result = boardDao.insertBoard(boardDto);
		if (result > 0) {
			ScriptWriter.alertAndNext(response, "글이 입력되었습니다.", "../board/list");
		} else {
			ScriptWriter.alertAndBack(response, "서버오류 잠시후 다시 시도해 주세요.");
		}
	}

}
