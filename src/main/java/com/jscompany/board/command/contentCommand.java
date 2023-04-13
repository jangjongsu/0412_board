package com.jscompany.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jscompany.board.controllor.dao.BoradDAO;
import com.jscompany.board.controllor.dto.BoardDTO;

public class contentCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BoradDAO dao = new BoradDAO();
		String bnum=request.getParameter("bnum");
		
		BoardDTO dto =dao.content_View(bnum);
		request.setAttribute("contentDTO", dto);
	}

}
