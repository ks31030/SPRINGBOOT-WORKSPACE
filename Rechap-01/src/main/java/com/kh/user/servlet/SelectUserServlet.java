package com.kh.user.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.user.dao.UserDAO;
import com.kh.user.dto.UserDTO;

//서블릿 연결
@WebServlet("/selectUser")
public class SelectUserServlet extends HttpServlet {
	//정보
	private static final long serialVersionUID = 1L;
	//클래스 버전 확인
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		int userNo	= Integer.parseInt(request.getParameter("userNo"));
		UserDAO dao = new UserDAO();
		UserDTO dto = dao.selectUser(userNo);
		request.setAttribute("User", dto);
		RequestDispatcher rd = null;
		
		if(dto != null) {
			rd = request.getRequestDispatcher("searchSuccess.jsp");
			rd.forward(request, response);
		} else {
			rd = request.getRequestDispatcher("searchFail.jsp");
			rd.forward(request, response);
		}
	}
}
