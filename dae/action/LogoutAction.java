package com.dts.dae.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dts.dae.dao.SecurityDAO;

public class LogoutAction extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session=request.getSession();
		System.out.println("in logout user="+session.getAttribute("user"));
		new SecurityDAO().loginaudit((String)session.getAttribute("user"));
		session.setAttribute("user",null);
		session.setAttribute("role", null);
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("LoginForm.jsp?status=logout successfully");
					rd.forward(request, response);	
	}

}
