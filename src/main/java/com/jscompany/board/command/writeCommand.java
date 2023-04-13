package com.jscompany.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jscompany.board.controllor.dao.BoradDAO;

public class writeCommand implements Command{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoradDAO dao = new BoradDAO();
		
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
	
		dao.write(writer, subject, content);
	}

}
