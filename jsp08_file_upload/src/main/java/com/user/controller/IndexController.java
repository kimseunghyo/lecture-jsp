package com.user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.model.ClockDao;
import com.user.model.ClockDto;

@WebServlet(urlPatterns = {"/index/*"})
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IndexController() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index/index.jsp");
    	ArrayList<ClockDto> clockList = new ArrayList<>();
    	ClockDao clockDao = new ClockDao();
    	clockList = clockDao.getAllClock();
    	request.setAttribute("clockList", clockList);
    	dispatcher.forward(request, response);
    }
}
