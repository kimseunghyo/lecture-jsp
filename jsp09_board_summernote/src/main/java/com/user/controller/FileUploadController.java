package com.user.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.user.utils.ScriptWriter;

@WebServlet("/board/summernoteFileUpload")
public class FileUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FileUploadController() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		int fileSize = 1024 * 1024 * 50; // �ѹ��� ���ε�Ǵ� ���� ������ �ִ� �뷮
		String encoding = "UTF-8"; // ���� ���ڵ� ������ UTF-8
		DefaultFileRenamePolicy fileRenamePolicy = new DefaultFileRenamePolicy(); // �̸��� �ߺ��� ������ ó��

		String savePath = "summerNoteUpload";
		String realPath = this.getServletContext().getRealPath(savePath);

		File dir = new File(realPath);
		if (!dir.exists()) {
			dir.mkdir();
		}

		MultipartRequest multipartRequest = new MultipartRequest(request, realPath, fileSize, encoding,
				fileRenamePolicy);

		String fileRealName = multipartRequest.getFilesystemName("uploadFile"); // �ߺ��� �̸� ó���ϴ� ��
		String fileUploadedUrl = "/jsp09_board_summernote/" + savePath + "/" + fileRealName;
		HashMap<String, String> fileUrlMap = new HashMap<>();
		fileUrlMap.put("fileUrl", fileUploadedUrl);
		Gson gson = new Gson();
		String fileUrl = gson.toJson(fileUrlMap);
		request.setAttribute("fileUrl", fileUrl);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/summernoteFileUpload.jsp");
		dispatcher.forward(request, response);
	}
}
