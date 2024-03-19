package com.dts.fss.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dts.fss.dao.DownloadDAO;
import com.dts.fss.model.Download;

public class OwnFileAction extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target = "DisplayFiles.jsp?status=Downloads are not available";
		try
		{
			HttpSession session=request.getSession();
		
			
			String fileID = request.getParameter("fileID");
			String subFolderID=request.getParameter("subFolderID");
			
			Download d=new Download();
			d.setFileID(Integer.parseInt(fileID));
			d.setSubFolderID(Integer.parseInt(subFolderID));
			String path=request.getRealPath("/userimages");
		String flag=new DownloadDAO().ownFileDownload(d,path);
		if(flag!=null)
			target = "Download.jsp?status="+flag;
		else
			target = "DisplayFiles.jsp?status= file Download Not supporting";
		}
		catch(Exception e)
		{target = "DisplayFiles.jsp?status= file Download Not supporting";
			e.printStackTrace();
		}
		finally
		{
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
		}    
	}

}
