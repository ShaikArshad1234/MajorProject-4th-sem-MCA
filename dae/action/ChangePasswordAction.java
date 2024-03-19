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
import com.dts.dae.model.Profile;

public class ChangePasswordAction extends HttpServlet {

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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session =request.getSession();
		
	  	if((String)session.getAttribute("user")==null)
	       response.sendRedirect("LoginForm.jsp?status=Session Expired");
	 
	 String page="";
	/* 
	  	if(((String)session.getAttribute("role")).equals("user"))
	  	{
	  	     page="userhome.jsp";
	  	 }else if(((String)session.getAttribute("role")).equals("admin")){
	  	     page="adminhome.jsp"; 
	  	}
	  	 else
	  		 page="LoginForm.jsp?status=Session Expired";
	  */
	    	String target="Changepassword.jsp?status=Password Changed Failed";
	       		Profile rb=new Profile(); 
	            rb.setPassword(request.getParameter("oldpassword")); 
	            rb.setLoginID(request.getParameter("username")); 
	            rb.setNewPassword(request.getParameter("newpassword")); 
	             
	            boolean flag=new SecurityDAO().changePassword(rb); 
	             
	            if(flag) 
	                target="UserHome.jsp?status=Password Changed Successfully"; 
	            else 
	                target="UserHome.jsp?status=Password Changed Failed"; 
	            RequestDispatcher rd = request.getRequestDispatcher(target);
	            rd.forward(request,response);
	}

}
