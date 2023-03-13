package com.user.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.user.model.ClockDao;
import com.user.model.ClockDto;
import com.user.utils.ScriptWriter;

@WebServlet("/fileupload")
public class FileUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FileUploadController() {
		super();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int fileSize = 1024 * 1024 * 50;  // �ѹ��� ���ε�Ǵ� ���� ������ �ִ� �뷮
		String encoding = "UTF-8";  // ���� ���ڵ� ������ UTF-8 
		DefaultFileRenamePolicy fileRenamePolicy = new DefaultFileRenamePolicy();  // �̸��� �ߺ��� ������ ó��
		
		String savePath = "uploadClock";
		String realPath = this.getServletContext().getRealPath(savePath);
		
		File dir = new File(realPath);
		if (!dir.exists()) {
			dir.mkdir();
		}
		
		MultipartRequest multipartRequest = new MultipartRequest(request, realPath, fileSize, encoding, fileRenamePolicy);
		
		String title = multipartRequest.getParameter("title");
		String category = multipartRequest.getParameter("category");
		int depth = Integer.parseInt(multipartRequest.getParameter("depth"));
		int price = Integer.parseInt(multipartRequest.getParameter("price"));
		String originalFile = multipartRequest.getOriginalFileName("file");
		String renameFile = multipartRequest.getFilesystemName("file");
		
		ClockDto clockDto = new ClockDto();
		ClockDao clockDao = new ClockDao();
		clockDto.setTitle(title);
		clockDto.setCategory(category);
		clockDto.setDepth(depth);
		clockDto.setPrice(price);
		clockDto.setClockImg(originalFile);
		clockDto.setClockRealImg(renameFile);
		int result = clockDao.insertClock(clockDto);
		
		if (result > 0) {
			ScriptWriter.alertAndNext(response, "���� ���ε� ����", "../index/");
		} else {
			ScriptWriter.alertAndBack(response, "���� ���ε� ����");
		}
	}
}
