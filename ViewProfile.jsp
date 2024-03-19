<%@ page import ="com.dts.dae.dao.*,com.dts.dae.model.*" %>

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
.Title1 {font-family:Verdana;
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
									<td background="images/split-bar.gif" bgcolor="#999999" height="20">
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
     
     
     Welcome To The User <%=(String)session.getAttribute("user") %>    
     
     <%
String name=(String)session.getAttribute("user");
String path=request.getRealPath("/userimages");

		
		Profile aprofile=new ProfileDAO().getProfile(name,path);

%>
     <br/>
     
     <br/>
     <p><img alt="See Photo Here" id="previewField" src="userimages/<%=session.getAttribute("user")%>.gif" height="150" width="120"></p>

     <table width="403" height="116" bordercolor="#FEE8B6">
       <tr><strong><span class="Title1"><u>Personal  Details
       </u></span></strong></tr>
       <tr>
         <td width="128" bgcolor="#FEE8B6"><strong><span class="style14 Title">FirstName</span></strong></td>
         <td width="366" bgcolor="#FEE8B6"><span class="Title1"><strong><%=aprofile.getFirstname()%></strong></span></td>
       </tr>
       <tr>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong>LastName</strong></span></td>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong><%=aprofile.getLastname()%></strong></span></td>
       </tr>
       <tr>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong>Dob</strong></span></td>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong><%=aprofile.getBdate()%></strong></span></td>
       </tr>
       <tr>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong>Email</strong></span></td>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong><%=aprofile.getEmail()%></strong></span></td>
       </tr>
       <tr>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong>Fax</strong></span></td>
         <td bgcolor="#FEE8B6"><span class="Title1"><strong><%=aprofile.getFax()%></strong></span></td>
       </tr>
     </table>
     
     <p></p>
  
<table border="1" align="center" bordercolor="#000000" bgcolor="#CCCCCC" width="719" height="20%">
  <br/>
  <br/>
  <tr><strong><span class="Title"><u> Address Details<br/>
            <br/>
  </u></span></strong></tr>
  <tr>
    <td bgcolor="#CCCCCC"><div align="center" class="Title">Address Type </div>      </td>
    <td bgcolor="#CCCCCC"><div align="center" class="Title">HouseNo</div></td>
    <td bgcolor="#CCCCCC"><div align="center" class="Title">Street</div></td>
    <td bgcolor="#CCCCCC"><div align="center" class="Title">City</div></td>
    <td bgcolor="#CCCCCC"><div align="center" class="Title">State</div></td>
    <td bgcolor="#CCCCCC"><div align="center" class="Title">Country</div></td>
    <td bgcolor="#CCCCCC"><div align="center" class="Title">PhoneNo</div></td>
  </tr>
  <%if(aprofile.getHome()!=null){ %>
  <tr>
    <td bgcolor="#FFFFFF"><span class="Title">Home</span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getHno()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getStreet()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getCity()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getState()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getCountry()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getPhone()%></span></td>
  </tr>
  <%}if(aprofile.getOffice()!=null){  %>
  <tr>
    <td bgcolor="#FFFFFF"><span class="Title">Office</span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getOhno()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getOstreet()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getOcity()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getOstate()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getOcountry()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getOphone()%></span></td>
  </tr>
  <%}if(aprofile.getContact()!=null){  %>
  <tr>
    <td bgcolor="#FFFFFF"><span class="Title">Personal</span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getChno()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getCstreet()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getCcity()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getCstate()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getCcountry()%></span></td>
    <td bgcolor="#FFFFFF"><span class="Title"><%=aprofile.getCphone()%></span></td>
  </tr>
  <%} %>
</table>

<p class="just">
<br>
<img src="images/paragraph-line.jpg" border="0"
		height="3" vspace="7" width="1200"">
	<br>
<!-- COPY AND PASTE CODE ABOVE HERE TO MAKE A NEW PARAGRAPH -->
			<!-- START CAREERS LIST -->
  </td>
 </table>
<!-- CONTENT TABLE -->
  </td>
</tr>
</tbody>
</table>
<tr>
<td valign="bottom">
<img src="images/stretchbar.jpg" alt="image" height="28"
	width="1200"">
	<br>

  </td>
</tr>
	</body>
</html>
