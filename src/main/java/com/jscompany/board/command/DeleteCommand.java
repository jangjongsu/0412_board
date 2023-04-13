package com.jscompany.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jscompany.board.controllor.dao.BoradDAO;

public class DeleteCommand implements Command{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String bnum = request.getParameter("bnum");
		BoradDAO dao = new BoradDAO();
		
		dao.content_Delete(bnum);
		
	}

}
