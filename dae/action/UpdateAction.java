package com.dts.dae.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.core.util.LoggerManager;
import com.dts.dae.dao.ProfileDAO;
import com.dts.dae.model.Profile;

public class UpdateAction extends HttpServlet {

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

		String target="UpdateProfile.jsp?status=Updation Failed"; 
		try{
			String username=(String)request.getSession().getAttribute("user");
		 Profile rb = new Profile(); 
	    rb.setPhoto(request.getParameter("photo"));
        rb.setFirstName(request.getParameter("firstName")); 
        rb.setLastName(request.getParameter("lastName")); 
     
        rb.setEmail(request.getParameter("email"));
        rb.setFax(request.getParameter("fax"));

        String home=request.getParameter("homeaddresstype");
        if(home!=null)
        {
        rb.setHome(home);	
        rb.setHno(request.getParameter("homehouseno"));
        rb.setStreet(request.getParameter("homestreet"));
        rb.setCity(request.getParameter("homecity")); 
        rb.setState(request.getParameter("homestate")); 
        rb.setCountry(request.getParameter("homecountry"));
        rb.setPin(request.getParameter("homepin"));
        rb.setHomePhoneType("home");
        rb.setPhone(request.getParameter("homephoneno"));
        }
        //office
        String office=request.getParameter("officeaddresstype");
        if(office!=null)
        {
        rb.setOffice(office);	
        rb.setOhno(request.getParameter("officehouseno"));
        rb.setOstreet(request.getParameter("officestreet"));
        rb.setOcity(request.getParameter("officecity")); 
        rb.setOstate(request.getParameter("officestate")); 
        rb.setOcountry(request.getParameter("officecountry"));
        rb.setOpin(request.getParameter("officepin"));
        rb.setOfficePhoneType("office");
        rb.setOphone(request.getParameter("officephoneno"));
        }
        //contact
        String contact=request.getParameter("personaladdresstype");
        if(contact!=null)
        {
       	rb.setContact(contact);	
       	rb.setChno(request.getParameter("personalhouseno"));
        rb.setCstreet(request.getParameter("personalstreet"));
        rb.setCcity(request.getParameter("personalcity")); 
        rb.setCstate(request.getParameter("personalstate")); 
        rb.setCcountry(request.getParameter("personalcountry"));
        rb.setCpin(request.getParameter("personalpin"));
        rb.setPersonalPhoneType("mobile");
        rb.setCphone(request.getParameter("personalphoneno"));
        }
        
       // rb.setStatus(1); 
        //rb.setFirstLogin(0); 
        rb.setLoginID(username); 
       
    
        
        boolean flag=new ProfileDAO().modifyProfile(rb);
        
        if(flag) 
           target = "UpdateProfile.jsp?status=Updation Success"; 
        else  
            target = "UpdateProfile.jsp?status=Updation Failed"; 
            }catch(Exception e)
            {
            	e.printStackTrace();
            	}
            
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request,response);
	}
}

