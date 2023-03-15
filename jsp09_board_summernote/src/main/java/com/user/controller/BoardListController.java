package com.user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.model.BoardDao;
import com.user.model.BoardDto;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao boardDao = new BoardDao();
		ArrayList<BoardDto> boardList = boardDao.getAll();
		request.setAttribute("boardList", boardList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/list.jsp");
		dispatcher.forward(request, response);
	}
}
