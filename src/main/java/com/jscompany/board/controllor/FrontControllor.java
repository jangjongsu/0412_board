package com.jscompany.board.controllor;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jscompany.board.command.*;
import com.jscompany.board.controllor.dao.BoradDAO;


@WebServlet("*.do")
public class FrontControllor extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	BoradDAO dao = new BoradDAO();

	
		
    public FrontControllor() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");  // 한글깨짐 방지 코드
		
		Command command = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String comm = uri.substring(conPath.length());
		System.out.println(comm);
		
		if(comm.equals("/write_Form.do")) {
			//System.out.println("boaradList.jsp 실행");
			RequestDispatcher rd = request.getRequestDispatcher("writeForm.jsp");
			rd.forward(request, response);
		}else if(comm.equals("/write.do")) {
			
			command = new writeCommand();
			command.execute(request, response);
			
			RequestDispatcher ds = request.getRequestDispatcher("list.do");
			ds.forward(request, response);
			
			
		} else if(comm.equals("/list.do")) {
			
			command = new listCommand();
			command.execute(request, response);
			
			RequestDispatcher ds = request.getRequestDispatcher("list.jsp");
			ds.forward(request, response);
		} else if (comm.equals("/contentView.do")) {
			
			command = new contentCommand ();
			command.execute(request, response);
			
			RequestDispatcher ds = request.getRequestDispatcher("contentView.jsp");
			ds.forward(request, response);
		} else if (comm.equals("/delete.do")) {
			
			command = new DeleteCommand();
			command.execute(request, response);
			
			RequestDispatcher ds = request.getRequestDispatcher("list.do");
			ds.forward(request, response);
	}
	}

}
