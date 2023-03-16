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

@WebServlet("/board/modifyProcess")
public class BoardModifyProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardModifyProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		BoardDto boardDto = new BoardDto();
		boardDto.setNo(Integer.parseInt(request.getParameter("no")));
		boardDto.setUserName(request.getParameter("userName"));
		boardDto.setTitle(request.getParameter("title"));
		boardDto.setContents(request.getParameter("contents"));
		BoardDao boardDao = new BoardDao();
		int result = boardDao.updateBoard(boardDto);
		
		if (result > 0) {
			ScriptWriter.alertAndNext(response, "���� �����Ǿ����ϴ�.", "../board/list");
		} else {
			ScriptWriter.alertAndBack(response, "���� ���� ����� �ٽ� �õ��� �ּ���.");
		}
	}

}
