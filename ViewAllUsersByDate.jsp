<%@ page import ="com.dts.dae.dao.*,com.dts.dae.model.*" %>
<%@page import="java.util.Enumeration,com.dts.core.util.CoreHash"%>
<%@page import="com.dts.core.util.DateWrapper"%>

<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
	<head>


		
		<title>File Sharing System</title>
		<meta name="Description"
			content="AllWebCo Website Templates and Pre-Made Websites. Very reasonable prices and a complete setup.">
		<meta name="KeyWords"
			content="website template, template, pre made web site, instant website,pre-made website,instant webpage,pre-made webpage">

		<!-- CHANGE THE ABOVE THREE LINES -->

		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<meta name="Copyright"
			content="Copyright 2002 AllWebCo Design http://allwebcodesign.com/">
		<meta name="Publisher"
			content="AllWebCo Templates http://allwebco-templates.com">
		<meta http-equiv="Content-Language" content="en">
		<meta name="revisit-after" content="15 days">
		<meta name="robots" content="index, follow">
		<meta name="Rating" content="General">
		<meta name="Robots" content="All">



		<link rel="StyleSheet" href="images/corporatestyle.css"
			type="text/css" media="screen">

<script language="JavaScript" src="scripts/gen_validatorv31.js" type="text/javascript"></script>
<script language="JavaScript" type="text/javascript" src="scripts/ts_picker.js"></script>
<script language="JavaScript1.1" src="scripts/pass.js">


</script> <script type="text/javascript" src="scripts/image.js"> </script>
 <script type="text/javascript" src="scripts/general.js"> </script>
 <script type="text/javascript" src="scripts/adi.js"> </script>
 <script type="text/javascript" src="scripts/form_validation.js"> </script>

		<script language="JavaScript" src="images/javascripts.js"></script>
		<script language="JavaScript" src="images/pop-closeup.js"></script>
		<style type="text/css">
.Title {
font-family:Verdana;
font-weight:bold;
font-size:8pt
}
</style><script type="text/javascript" src="scripts/project.js"></script>
	</head>
	<body leftmargin="0" rightmargin="0" topmargin="0" bottommargin="0"
		alink="#666666" background="images/background-main.jpg"
		bgcolor="#ffffff" link="#4e172a" marginheight="0" marginwidth="0"
		text="#000000" vlink="#4e172a">
		<div class="divstyle" id="info"
			style="display: none; top: 293px; left: 526px;">
			<div id="imagetitle" class="pstyletitle" align="center"></div>
		</div>





		<!-- PAGE TABLE-->
		<table border="0" cellpadding="0" cellspacing="0" height="100%"
			width="1200"">
			<tbody>
				<tr>
					<td align="left" valign="top"><script language="JavaScript" src="images/header.js"></script>
						<table bgcolor="#909099" border="0" cellpadding="0"
							cellspacing="0" width="1200"">
							<tbody>
								<tr bgcolor="#FC985C">
									<td width="15">
										<br>
								  </td>
									<td align="left" valign="CENTER"><jsp:include
											page="header.html" /></td>
									<td align="right" valign="CENTER">
										<nobr>
											<span class="slogan"> </span>
											<br>
								  </td>
									<td width="15">
										<img src="images/spacer.gif" border="0" height="10" width="15">
										<br>
								  </td>
							  </tr>
							</tbody>
					  </table>
						
<table border="0" cellpadding="0" cellspacing="0" width="1200"">
							<tbody>
								<tr>
									<td>
										<img src="images/careers.jpg" alt="image" border="0"
											height="200" width="1200"></td>
								</tr>
								<tr>
									<td background="images/split-bar.gif" bgcolor="#999999"  height="20">
								<%if(session.getAttribute("role")!=null){
   				if (session.getAttribute("role").equals("admin"))
		
					{%>
					<jsp:include page="adminoptions.html"/>
					<% }
				else if (session.getAttribute("role").equals("user"))
					{%>
					
					<jsp:include page="useroptions.html"/>			
					<%}
				else {%>
						<jsp:include page="generaloptions.html"/>
					<%}}
					else{
					response.sendRedirect("LoginForm.jsp?status=session expired login again...." );
			}		%>

									</td>
								</tr>
							</tbody>
					  </table>



						<!-- OUTER TABLE-->
						<table border="0" cellpadding="0" cellspacing="0" width="1200"">
							<tbody>
								<tr>
									<td align="center" valign="top" bgcolor="#FEE8B6">

	 
      
		<p>&nbsp;</p>
		<p>&nbsp;</p>
      <p>&nbsp;</p>

<table  border="0" align="center"  bgcolor="white" width="80%">      
        <tr>
                 <td height="120" bgcolor="#FDF1C1">


      
      <strong><br>
      </strong>
     <p align="center"><strong>
      
    
     Welcome To The User <%=(String)session.getAttribute("user") %>    
     
   
     <br/>
     <br/>
     </strong></p>
      
<table border="1" align="center" bordercolor="#000000" bgcolor="#66CCFF" width="719" height="20%">
  <br/>
  <br/>
  <%String sdate=DateWrapper.parseDate(request.getParameter("fromdate"));
		   String edate=DateWrapper.parseDate(request.getParameter("todate")); %>
  <tr><strong><span class="style16"> Report Details From <%=sdate %> to <%=edate %><br/>
            <br/>
  </span></strong></tr>
  <tr>
    
    <td bgcolor="#E0FEFD"><div align="center" class="style16">LoginID</div></td>
    <td bgcolor="#E0FEFD"><div align="center" class="style16">FirstName</div></td>
    <td bgcolor="#E0FEFD"><div align="center" class="style16">LastName</div></td>
    <td bgcolor="#E0FEFD"><div align="center" class="style16">Email</div></td>
    <td bgcolor="#E0FEFD"><div align="center" class="style16">DOB</div></td>
    <td bgcolor="#E0FEFD"><div align="center" class="style16">RegisterDate</div></td>
    <%--<td bgcolor="#E0FEFD"><div align="center" class="style16">Photo</div></td>
  --%></tr>
  <%int sno=1;
		   
		   CoreHash aCoreHash=new ProfileDAO().getReportFromTo(sdate,edate);
		   System.out.println(sdate+""+edate);
		   Enumeration e=aCoreHash.keys();
		   while(e.hasMoreElements())
		   {
		   Integer i=(Integer)e.nextElement();
		   Profile aProfile=(Profile)aCoreHash.get(i);
		   
		   %>
  
 <tr>
    
    <td bgcolor="#EFFEFF"><div align="center" class="style16"><%=aProfile.getLoginID() %></div></td>
    <td bgcolor="#EFFEFF"><div align="center" class="style16"><%=aProfile.getFirstName() %></div></td>
    <td bgcolor="#EFFEFF"><div align="center" class="style16"><%=aProfile.getLastName() %></div></td>
    <td bgcolor="#EFFEFF"><div align="center" class="style16"><%=aProfile.getEmail() %></div></td>
    <td bgcolor="#EFFEFF"><div align="center" class="style16"><%=aProfile.getBirthDate() %></div></td>
    <td bgcolor="#EFFEFF"><div align="center" class="style16"><%=aProfile.getRegDate() %></div></td>
    <%--<td bgcolor="#EFFEFF"><div align="center" class="style16"><img alt="See Photo Here" id="previewField" src="userimages/<%=session.getAttribute("user")%>.gif" height="25" width="22"></div></td>
  --%></tr>
  <%} %>
</table>
		 </td></tr></table>

		<p class="just">
			<br>

			<img src="images/paragraph-line.jpg" border="0"
				height="3" vspace="7" width="1200"">
			<br>

			<!-- COPY AND PASTE CODE ABOVE HERE TO MAKE A NEW PARAGRAPH -->







					

	  </td>
									</tr>
								</tbody>
							</table>
							<!-- SPLIT TABLE -->

			<!-- OUTER TABLE-->







	<tr>
		<td valign="bottom" bgcolor="#FEE8B6">

			<img src="images/stretchbar.jpg" alt="image" height="28"
				width="1200"">
			<br>


			<!-- COPYRIGHT -->
			<!-- COPYRIGHT -->
		</td>
	</tr>
<!-- END PAGE TABLE-->

	</body>
</html>
  
  