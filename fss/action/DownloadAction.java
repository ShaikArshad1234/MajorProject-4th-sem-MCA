package com.dts.fss.action;

import java.io.IOException;
import java.io.PrintWriter;
import com.dts.fss.dao.DownloadDAO;
import com.dts.fss.model.Download;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dts.dae.model.Profile;

public class DownloadAction extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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

		String target = "UserHome.jsp?status=Downloads are not available";
		try
		{
			HttpSession session=request.getSession();
		
			
			String fileID = request.getParameter("fileID");
			String subFolderID=request.getParameter("subFolderID");
			String folderID=request.getParameter("folderID");
			Download d=new Download();
			d.setFileID(Integer.parseInt(fileID));
			d.setSubFolderID(Integer.parseInt(subFolderID));
			d.setFolderID(Integer.parseInt(folderID));
			d.setLoginID((String)session.getAttribute("user"));
			String path=request.getRealPath("/userimages");
		String flag=new DownloadDAO().fileDownload(d,path);
		if(flag!=null)
			target = "Download.jsp?status="+flag;
		else
			target = "UserHome.jsp?status= file Download Not supporting";
		}
		catch(Exception e)
		{target = "UserHome.jsp?status= file Download Not supporting";
			e.printStackTrace();
		}
		finally
		{
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
		}    
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
