package com.jscompany.board.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jscompany.board.controllor.dao.BoradDAO;
import com.jscompany.board.controllor.dto.BoardDTO;

public class listCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoradDAO dao = new BoradDAO();
		
		ArrayList<BoardDTO> dtos = dao.list();
		request.setAttribute("list", dtos);

	}

}
